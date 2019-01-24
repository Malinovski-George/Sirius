package by.malinovski.book.controller;

import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.User;
import by.malinovski.book.service.impl.FlatService;
import by.malinovski.book.service.impl.UserService;
import net.sf.ehcache.CacheManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

  @Autowired FlatService flatService;

  @Autowired UserService userService;

  @RequestMapping(
      path = {"/", "/home"},
      method = RequestMethod.GET)
  public ModelAndView showHome() {

    List<SimpleFlatDto> allFlats = flatService.getAllSimpleFlatsDto();

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("home");
    modelAndView.addObject("appName", "asdasd");
    modelAndView.addObject("flats", allFlats);
    modelAndView.addObject("fields", allFlats.size());
    return modelAndView;
  }

  @RequestMapping(value = "/accessDeniedPage", method = RequestMethod.GET)
  public String AccessDinied() {
    return "/accessDeniedPage";
  }

  @RequestMapping(value = "/user-page", method = RequestMethod.GET)
  public ModelAndView UserPage(Principal principal) {

    User user = userService.getUserByEmail(principal.getName());
    List<SimpleFlatDto> flats = flatService.getSimpleFlatDtoByUser(user);

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("user-page");
    modelAndView.addObject("flats", flats);

    return modelAndView;
  }


  @RequestMapping(value = "/claerCache", method = RequestMethod.GET)
  public void clearCache()
    {
    CacheManager.getInstance().clearAll();
  }

}
