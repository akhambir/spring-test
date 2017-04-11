package com.akhmbir.controller;


import com.akhmbir.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    private static List<User> userDb = new ArrayList<>();

    static {
        userDb.add(new User("Vasya", "123456"));
        userDb.add(new User("Vasya2", "123456"));
    }

    @RequestMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("newUser", new User());
        return "login";
    }

    @RequestMapping(value = "/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout, Model model) {

        if (error != null) {
            model.addAttribute("error", "Invalid username or password!");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully!");
        }
        return "login";

    }

}
