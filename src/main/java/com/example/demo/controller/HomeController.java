package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // display list of employees
    @GetMapping("/login")
    public String login() {
        return "index";
    }

    // display list of employees
    @GetMapping("/home")
    public String viewHomePage(Model model) {
        model.addAttribute("title","Home");
        return "home/index";
    }

}
