package by.malinovski.book.controller;

import by.malinovski.book.dto.FlatSimpleModelDto;
import by.malinovski.book.dto.RegistrationFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FlatController {

//simple registration
    @RequestMapping(path = {"/registrationForm"}, method = RequestMethod.GET)
    public ModelAndView newFlatRegistrationFormGet() {
//    public String showHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrationForm");

        FlatSimpleModelDto flatDto = new FlatSimpleModelDto();
        modelAndView.addObject("flat", flatDto);
        modelAndView.addObject("registrationFormDto", new RegistrationFormDto());
        return modelAndView;
//        return "home";
    }


    @RequestMapping(path = {"/registrationForm"}, method = RequestMethod.POST)
    public String registrationFormPost1(@ModelAttribute RegistrationFormDto registrationFormDto, Model model) {

        model.addAttribute("registrationFormDto", registrationFormDto);
        return "done";
    }


   /* @RequestMapping(path = {"/registrationForm"}, method = RequestMethod.POST)
    public String registrationFormPost(@ModelAttribute RegistrationFormDto registrationFormDto, Model model) {

        model.addAttribute("registrationFormDto", registrationFormDto);
        return "done";
    }*/

}
