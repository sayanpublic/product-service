package com.sayanpublic.productService.service;

import static org.springframework.beans.BeanUtils.copyProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayanpublic.productService.entity.Product;
import com.sayanpublic.productService.exception.ProductServiceCustomException;
import com.sayanpublic.productService.model.ProductRequest;
import com.sayanpublic.productService.model.ProductResponse;
import com.sayanpublic.productService.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public long addProduct(ProductRequest productRequest) {
		log.info("Adding product ...");
		Product product = Product.builder()
				.productName(productRequest.getName())
				.quantity(productRequest.getPrice())
				.price(productRequest.getPrice())
				.build();
		productRepository.save(product);
		log.info("Product created ...");
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(long productId) {
		log.info("Getting the product for productId: {}", productId);
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceCustomException("Product with the given id "+productId+" not found!", "PRODUCT_NOT_FOUND"));
		ProductResponse productResponse = new ProductResponse();
		copyProperties(product, productResponse);
		return productResponse;
	}

}
