package by.malinovski.book.controller;

import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.dto.RegistrationFormDto;
import by.malinovski.book.model.User;
import by.malinovski.book.service.IFlatService;
import by.malinovski.book.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class FlatController {

    @Autowired
    IFlatService flatService;

    @Autowired
    UserService userService;

//simple registration
    @RequestMapping(path = {"/registrationForm"}, method = RequestMethod.GET)
    public ModelAndView newFlatRegistrationFormGet() {
//    public String showHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrationForm");

        SimpleFlatDto flatDto = new SimpleFlatDto();
        modelAndView.addObject("flat", flatDto);
        modelAndView.addObject("simpleFlatDto", new SimpleFlatDto());
        return modelAndView;
//        return "home";
    }


    @RequestMapping(path = {"/registrationForm"}, method = RequestMethod.POST)
    public String registrationFormPost1(@ModelAttribute SimpleFlatDto simpleFlatDto, Principal principal) {
        User user = userService.getUserByEmail(principal.getName());
        flatService.saveNewFlat(simpleFlatDto, user);

        return "home";
    }


   /* @RequestMapping(path = {"/registrationForm"}, method = RequestMethod.POST)
    public String registrationFormPost(@ModelAttribute RegistrationFormDto registrationFormDto, Model model) {

        model.addAttribute("registrationFormDto", registrationFormDto);
        return "done";
    }*/

}
