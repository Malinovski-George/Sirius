package by.malinovski.book.controller;

import by.malinovski.book.dao.impl.PhotoDao;
import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.Photos.FlatPhoto;
import by.malinovski.book.model.User;
import by.malinovski.book.service.IFlatService;
import by.malinovski.book.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;

@Controller
public class FlatController {

    @Autowired
    IFlatService flatService;

    @Autowired
    UserService userService;

    @Autowired
    PhotoDao photoDao;

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


//    @RequestMapping(path = {"/registrationForm"}, method = RequestMethod.POST)
@PostMapping("/registrationForm")
    public String registrationFormPost1(@Valid SimpleFlatDto simpleFlatDto, BindingResult result, Principal principal) throws IOException {


        if (result.hasErrors()) {
            return "registrationForm";
        }

        User user = userService.getUserByEmail(principal.getName());
        flatService.saveNewFlat(simpleFlatDto, user);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.setStatus(HttpStatus.OK);
        return "redirect:/";
    }


   /* @RequestMapping(path = {"/registrationForm"}, method = RequestMethod.POST)
    public String registrationFormPost(@ModelAttribute RegistrationFormDto registrationFormDto, Model model) {

        model.addAttribute("registrationFormDto", registrationFormDto);
        return "done";
    }*/

    @RequestMapping(path = {"/image/{imgid}"}, method = RequestMethod.GET)
    public void registrationFormPost1(HttpServletRequest request, @PathVariable(value = "imgid") String imgid, HttpServletResponse response) throws IOException {

        FlatPhoto photo = photoDao.getPhotoById(imgid);

        response.reset();
        String contentType = "img/png";
//        response.setContentType("multipart/form-data");
        response.setContentType(contentType);
        response.setContentLength((int) photo.getImage().length);

        OutputStream out = response.getOutputStream();
        out.write(photo.getImage());
        out.flush();
        out.close();

        response.setStatus(HttpServletResponse.SC_OK);

    }

    // TODO GM: RequestMethod.GET => RequestMethod.DELETE
    @RequestMapping(path = {"/flats/{id}"}, method = RequestMethod.GET)
    public String deleteFlat(Principal principal, @PathVariable(value = "id") String id) throws IOException {
        User user = userService.getUserByEmail(principal.getName());
        if (flatService.canDelete(user, Integer.valueOf(id))) {
            flatService.delete(Integer.valueOf(id));
        }
        return "redirect:/";
    }

}
