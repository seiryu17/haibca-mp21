package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public String viewProducPage(Model model){
        model.addAttribute("title", "Product Page");
        model.addAttribute("listProducts", productService.getAllProducts());
        return "product/index";
    }

    @GetMapping("/products/new-product")
    public String newProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "product/new-product";
    }

    @PostMapping("/products/saveProduct")
    public String saveProduct(@ModelAttribute("Product") Product product) {
    	productService.saveProduct(product);;
    	return "redirect:/products";
    }

    @GetMapping("/products/edit-product/{id}")
    public String editProduct(@PathVariable(value = "id") long id, Model model) {

        // get product from the service
        Product product = productService.getProductById(id);

        // set product as a model attribute to pre-populate the form
        model.addAttribute("product", product);
        return "product/edit-product";
    }

    @GetMapping("/products/delete-product/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {

        // call delete employee method 
        this.productService.deleteProductById(id);
        return "redirect:/products";
    }
}
