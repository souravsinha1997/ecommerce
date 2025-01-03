package com.sourav.order.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sourav.order.exception.BusinessException;
import com.sourav.order.product.entity.Product;

@Service
public class ProductClient {

	@Value("${application.config.product-url}")
	private String productUrl;
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Product> purchaseProducts(List<Product> products){
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE,  MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity<List<Product>> requestEntity = new HttpEntity<>(products, headers);
		ParameterizedTypeReference<List<Product>> responseType = new ParameterizedTypeReference<>() {};
		ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(productUrl+"/purchase", HttpMethod.POST,requestEntity,responseType);
		
		if(responseEntity.getStatusCode().isError())
			throw new BusinessException("Error occured while processing the products purchase "+responseEntity.getStatusCode());
			
		return responseEntity.getBody();
	}
	
}
