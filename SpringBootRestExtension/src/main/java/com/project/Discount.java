package com.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
	public int productId;
	public int discountPercentage;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public int getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}
	public int taxRate;
	
}
