package com.sourav.product.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.product.entity.Product;
import com.sourav.product.exception.ProductException;
import com.sourav.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public int createProduct(Product product) {
		productRepository.save(product);
		return product.getId();
	}

	public List<Product> purchaseProducts(List<Product> products) {
		
		List<Integer> productIds = products.stream().map(p-> p.getId()).toList();
		System.out.println(products);
		List<Product> storedProducts = productRepository.findAllByIdInOrderById(productIds);
		System.out.println(storedProducts);
		if(products.size()!=storedProducts.size()) throw new ProductException("Products are not available");
		
		List<Product> sortedProducts = products.stream().sorted(Comparator.comparing(Product::getId)).toList();
		List<Product> sortedStored = storedProducts.stream().sorted(Comparator.comparing(Product::getId)).toList();
		
		
		for(int i=0;i<sortedProducts.size();i++) {
			if(sortedProducts.get(i).getAvailableQuantity()>sortedStored.get(i).getAvailableQuantity()) throw new RuntimeException("Product quantity is not present");
			
			double newQuantity = sortedStored.get(i).getAvailableQuantity()-sortedProducts.get(i).getAvailableQuantity();
			Product newProduct = sortedStored.get(i);
			newProduct.setAvailableQuantity(newQuantity);
			productRepository.save(newProduct);
		
		}
		
		
		return sortedProducts;
	}

	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	public Product getProduct(int id) {
		Product product = productRepository.findById(id).orElse(null);
		if(product == null) {
			throw new ProductException("Prodcut id does not exist ID: "+id);
		}
		return product;
	}

}
