package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MarketController {

    // display list of employees
    @GetMapping("/market")
    public String market() {
        return "market/index";
    }

    // display list of employees
    @GetMapping("/detail-product/{id}")

    public String viewDetailProduct(@PathVariable(value = "id") long id) {
        return "market/detail-product";
    }

}
