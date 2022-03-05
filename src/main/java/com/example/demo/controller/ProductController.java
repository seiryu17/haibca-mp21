package com.example.demo.controller;

import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// display list of employees
    @GetMapping("/product")
    public String viewProductPage(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "product/index";
    }
}
