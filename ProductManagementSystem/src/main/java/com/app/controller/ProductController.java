package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins="http://localhost:3000")
public class ProductController {
		@Autowired
		private ProductService prodService;
		public ProductController() {
			System.out.println("in def ctor of "+getClass());
		}
		
		@GetMapping
		public List<Product> ListProducts(){
			System.out.println("in listProd");
			return prodService.getAllProducts();
		}
		
		@PostMapping
		public ResponseEntity<?> saveProduct(@RequestBody Product transientProd) {
			System.out.println("in saveProd of"+transientProd);
			return new ResponseEntity<>(prodService.addProdDetails(transientProd),HttpStatus.CREATED);
		}
		
		@GetMapping("/{prodId}")
		public Product getProdDetails(@PathVariable Long prodId) {
			System.out.println("in get prod details "+prodId);
			return prodService.getProdDetails(prodId);
		}
}
