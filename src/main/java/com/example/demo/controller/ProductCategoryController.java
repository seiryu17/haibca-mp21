package com.example.demo.controller;

import com.example.demo.model.ProductCategory;
import com.example.demo.service.ProductCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/category")
    public String viewCategoryPage(Model model) {
        model.addAttribute("title", "Category Page");
        model.addAttribute("listProductCategory", productCategoryService.getAllProductCategory());
        return "category/index";
    }

    @GetMapping("/category/new-category")
    public String newCategory(Model model) {
        ProductCategory productCategory = new ProductCategory();
        model.addAttribute("productCategory", productCategory);
        return "category/new-category";
    }

    @PostMapping("/category/saveCategory")
    public String saveCategory(@ModelAttribute("ProductCategory") ProductCategory category) {
        productCategoryService.saveProductCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/category/edit-category/{id}")
    public String editCategory(@PathVariable(value = "id") long id, Model model) {

        // get category from the service
        ProductCategory productCategory = productCategoryService.getProductCategoryById(id);

        // set category as a model attribute to pre-populate the form
        model.addAttribute("productCategory", productCategory);
        return "category/edit-category";
    }

    @GetMapping("/category/delete-category/{id}")
    public String deleteCategory(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.productCategoryService.deleteProductCategoryById(id);
        return "redirect:/category";
    }

    @GetMapping("/view-category/{id}")
    public String viewCategory(@PathVariable(value = "id") long id, Model model) {

        // get product from the service
        ProductCategory productCategory = productCategoryService.getProductCategoryById(id);
        // set product as a model attribute to pre-populate the form
        model.addAttribute("productCategory", productCategory);

        return "category/view-category";
    }

}
