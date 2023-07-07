package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.entity.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository prodRepo;

	@Override
	public List<Product> getAllProducts() {
		return prodRepo.findAll();
	}

	@Override
	public Product addProdDetails(Product transientProd){
		if(transientProd.getPrice()>500)
			return prodRepo.save(transientProd);
		else
			throw new ResourceNotFoundException("Invalid !! product price should be greater than 500!!!!!!!");
	}

	@Override
	public Product getProdDetails(Long prodId) {
		return prodRepo.findById(prodId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid product Id,cant fetch product details!!!!!!!"));
	}
	
}
