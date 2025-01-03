package com.sourav.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.product.entity.Product;
import com.sourav.product.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<Integer> createProduct(@RequestBody @Valid Product product){
		return ResponseEntity.ok(productService.createProduct(product));
	}
	
	@PostMapping("/purchase")
	public ResponseEntity<List<Product>> purchaseProducts(@RequestBody List<Product> products){
		return ResponseEntity.ok(productService.purchaseProducts(products));
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id){
		return ResponseEntity.ok(productService.getProduct(id));
	}
}
