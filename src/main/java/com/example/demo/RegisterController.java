package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RegisterController {
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(User user) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
        public String register(
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password, Model model ){
        User user = new User(firstName, lastName, email, password);
        if ( (user.valid_firstName(firstName)) && (user.valid_lastName(lastName))
                && (user.valid_email(email)) && (user.valid_password(password)))
        return "redirect:/login";
        return "redirect:/register";
    }
}