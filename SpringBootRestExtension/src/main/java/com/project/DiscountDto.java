package com.project;

import lombok.Data;

@Data
public class DiscountDto {

	private String message;
	private Product product;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
