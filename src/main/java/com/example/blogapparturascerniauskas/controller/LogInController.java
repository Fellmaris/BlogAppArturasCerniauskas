package com.example.blogapparturascerniauskas.controller;

import com.example.blogapparturascerniauskas.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LogInController {

    @GetMapping
    public String getLogIn(Model model){
        model.addAttribute("user", new User());
        return "login";
    }
}
