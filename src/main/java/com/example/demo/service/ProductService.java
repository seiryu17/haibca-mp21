package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Product saveProduct(Product product);

	Product getProductById(long id);

	void deleteProductById(long id);
}
