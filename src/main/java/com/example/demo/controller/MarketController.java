package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.ProductService;
import org.springframework.ui.Model;

@Controller
public class MarketController {

    @Autowired
    private ProductService productService;

    // display list of employees
    @GetMapping("/")
    public String market() {
        return "market/index";
    }

    // display list of employees
    @GetMapping("/product-list")
    public String viewProductList(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "market/product-list";
    }

    // display list of employees
    @GetMapping("/detail-product/{id}")
    public String viewDetailProduct(@PathVariable(value = "id") long id) {
        return "market/detail-product";
    }

    // display list of employees
    @GetMapping("/checkout")
    public String viewCheckout() {
        return "market/checkout";
    }

}
