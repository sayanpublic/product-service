package com.sayanpublic.productService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayanpublic.productService.model.ProductRequest;
import com.sayanpublic.productService.model.ProductResponse;
import com.sayanpublic.productService.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
		long productId = productService.addProduct(productRequest);
		return new ResponseEntity<>(productId, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable long id) {
		ProductResponse productResponse = productService.getProductById(id);
		return new ResponseEntity<>(productResponse, HttpStatus.FOUND);
	}

}
