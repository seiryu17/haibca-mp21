package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // display list of employees
    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }
}
