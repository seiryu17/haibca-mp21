package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ProductCategory;

public interface ProductCategoryService {
    List<ProductCategory> getAllProductCategory();
    void saveProductCategory(ProductCategory productCategory);
    ProductCategory getProductCategoryById(Long id);
    void deleteProductCategoryById(Long id);
}
