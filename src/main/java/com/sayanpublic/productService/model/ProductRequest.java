package com.sayanpublic.productService.model;

import lombok.Data;

@Data
public class ProductRequest {
	private String name;
	private long price;
	private long quantity;
}
