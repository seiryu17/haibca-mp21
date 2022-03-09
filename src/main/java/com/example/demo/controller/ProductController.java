package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.example.demo.model.Product;
import com.example.demo.service.ProductCategoryService;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    // display list of employees
    @GetMapping("/product")
    public String viewProductPage(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        model.addAttribute("title", "Product Page");
        return "product/index";
    }

    @GetMapping("/new-product")
    public String newProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("listCategory", productCategoryService.getAllProductCategory());
        return "product/new-product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("Product") Product product,
            @RequestParam("fileImage") MultipartFile multipartFile) {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if (fileName != "") {
            product.setProductImg(fileName);
            Product savedProduct = productService.saveProduct(product);
            String upload_dir = "./product-image/" + savedProduct.getId();
            Path uploadPath = Paths.get(upload_dir);

            if (!Files.exists(uploadPath)) {
                try {
                    Files.createDirectories(uploadPath);
                } catch (IOException e) {
                    System.out.println("createDirectory failed:" + e);
                }
            }

            try (InputStream inputStream = multipartFile.getInputStream()) {
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Failed" + e);
            }
        }else{
            product.setProductImg(null);
            productService.saveProduct(product);
        }

        return "redirect:/product";
    }

    @GetMapping("/edit-product/{id}")
    public String editProduct(@PathVariable(value = "id") long id, Model model) {

        // get product from the service
        Product product = productService.getProductById(id);

        // set product as a model attribute to pre-populate the form
        model.addAttribute("product", product);
        model.addAttribute("listCategory", productCategoryService.getAllProductCategory());
        return "product/update-product";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.productService.deleteProductById(id);
        return "redirect:/product";
    }

    @GetMapping("/view-product/{id}")
    public String viewProduct(@PathVariable(value = "id") long id, Model model) {

        // get product from the service
        Product product = productService.getProductById(id);
        // set product as a model attribute to pre-populate the form
        model.addAttribute("product", product);
        return "product/view-product";
    }
}
