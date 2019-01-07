package by.malinovski.book.controller;

import by.malinovski.book.dto.UserDto;
import by.malinovski.book.exceptions.EmailExistsException;
import by.malinovski.book.model.User;
import by.malinovski.book.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    IUserService service;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login.html";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

//    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
//    public String tickets(Model model) {
//        return "home";
//    }

    @RequestMapping("/userRegistration")
    public String registration(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "userRegistration.html";
    }

    //////////////////////////

  /*  @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") @Valid UserDto accountDto,
             BindingResult result, WebRequest request, Errors errors) {
        User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        // rest of the implementation
    }
    private User createUserAccount(UserDto accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = service.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }*/
    @RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDto accountDto,
            BindingResult result,
            WebRequest request,
            Errors errors) {

        User registered = new User();
        if (!result.hasErrors()) {
//            registered = createUserAccount(accountDto, result);
            createUserAccount(accountDto, result);
        }
//        if (registered == null) {
//            result.rejectValue("email", "message.regError");
//        }
        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", accountDto);
        }
        else {
            return new ModelAndView("home", "user", accountDto);
        }
    }
//    private User createUserAccount(UserDto accountDto, BindingResult result) {
    private void createUserAccount(UserDto accountDto, BindingResult result) {
        User registered = null;
        try {
//            registered = service.registerNewUserAccount(accountDto);
            service.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
//            return null;
        }
//        return registered;
    }
}
