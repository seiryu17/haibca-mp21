package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarketController {

    // display list of employees
    @GetMapping("/market")
    public String market() {
        return "market/index";
    }

}
