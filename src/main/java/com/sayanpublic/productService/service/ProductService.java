package com.sayanpublic.productService.service;

import com.sayanpublic.productService.model.ProductRequest;
import com.sayanpublic.productService.model.ProductResponse;

public interface ProductService{

	long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(long id);

}
