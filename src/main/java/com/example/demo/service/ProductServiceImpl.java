package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        return productRepo.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        // TODO Auto-generated method stub
        this.productRepo.save(product);
        
    }

    @Override
    public Product getProductById(Long id) {
        // TODO Auto-generated method stub
        Optional <Product> optional = productRepo.findById(id);
        Product product = null;
        if(optional.isPresent()){
            product = optional.get();
        }else{
            throw new RuntimeException(" Product not found for id :: " + id);
        }
        return product;
    }

    @Override
    public void deleteProductById(Long id) {
        // TODO Auto-generated method stub
        this.productRepo.deleteById(id);
        
    }
}
