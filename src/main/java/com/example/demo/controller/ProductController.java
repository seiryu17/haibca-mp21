package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/new-product")
    public String newProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product/new-product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("Product") Product product) {
        productService.saveProduct(product);
        return "redirect:/product";
    }
}
