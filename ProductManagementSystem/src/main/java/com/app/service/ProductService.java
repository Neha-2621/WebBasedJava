package com.app.service;

import java.util.List;

import com.app.entity.Product;

public interface ProductService {
		List<Product> getAllProducts();

		Product addProdDetails(Product transientProd);

		Product getProdDetails(Long prodId);
}
