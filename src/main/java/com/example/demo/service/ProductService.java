package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	List<Product> getAllProducts();

	void saveProduct(Product product);
	// User getUserById(long id);
	// void deleteUserById(long id);
}
