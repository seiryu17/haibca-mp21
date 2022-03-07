package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.ProductCategory;
import com.example.demo.repository.ProductCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
    @Autowired
    private ProductCategoryRepository productCategoryRepo;

    @Override
    public List<ProductCategory> getAllProductCategory() {
        // TODO Auto-generated method stub
        return productCategoryRepo.findAll();
    }

    @Override
    public void saveProductCategory(ProductCategory productCategory) {
        // TODO Auto-generated method stub
        this.productCategoryRepo.save(productCategory);
    }

    @Override
    public ProductCategory getProductCategoryById(Long id) {
        // TODO Auto-generated method stub
        Optional <ProductCategory> optional = productCategoryRepo.findById(id);
        ProductCategory productCategory = null;
        if(optional.isPresent()){
            productCategory = optional.get();
        }else{
            throw new RuntimeException(" Category not found for id :: " + id);
        }
        return productCategory;
    }

    @Override
    public void deleteProductCategoryById(Long id) {
        // TODO Auto-generated method stub
        this.productCategoryRepo.deleteById(id);
    }

    
}
