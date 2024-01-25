package com.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// create
	public Product createProduct(Product product) {
		productRepository.save(product);
		return getProductById(product.getId());
	}

	// update Product
	public String updateProduct(Product product) throws Exception {

		Optional<Product> updatedProductObj = productRepository.findById(product.getId());

		if (updatedProductObj.isEmpty()) {
			return "No Product found to update";
		} else {
			Product updateProduct = updatedProductObj.get();
			updateProduct.setName(product.getName());
			updateProduct.setPrice(product.getPrice());
			updateProduct.setTotal(product.getTotal());
			updateProduct.setQuantity(product.getQuantity());
			updateProduct.setDate(product.getDate());
			productRepository.save(updateProduct);
			return "Product is updated Successfully";

		}
	}

	// read Product
	public Product getProductById(int id) {

		Product product = null;
		Optional<Product> productObj = productRepository.findById(id);
		if (productObj.isEmpty()) {
			return product;
		} else {
			return product = productObj.get();
		}
	}

	// delete
	public String deleteProductById(int id) {
		Optional<Product> productObj = productRepository.findById(id);
		if (productObj.isEmpty()) {
			return "No Product found to delete";
		} else {
			productRepository.deleteById(id);
		}

		return "Product deleted Successfully";
	}

	public DiscountDto updateProductDiscount(Discount discount) {

		Product product = getProductById(discount.getProductId());
		DiscountDto discountDto = new DiscountDto();
		discountDto.setMessage("Discount Failure");
		if (product == null) {
			discountDto.setMessage("Discount Failure");
		} else {

			if (discount.getTaxRate() > 0 && discount.getTaxRate() < 100) {

				double discountAmount = (discount.getTaxRate() / 100.0) * product.getTotal();
				discountAmount = product.getTotal() + discountAmount;
				product.setTotal(discountAmount);
				discountDto.setProduct(product);
				discountDto.setMessage("Tax Rate Success");
			}
			if (discount.getDiscountPercentage() > 0 && discount.getDiscountPercentage() < 100) {
				double discountAmount = (discount.getDiscountPercentage() / 100.0) * product.getTotal();
				discountAmount = product.getTotal() - discountAmount;
				product.setTotal(discountAmount);
				discountDto.setProduct(product);
				discountDto.setMessage("Discount Success");
			}
			productRepository.save(product);
		}

		return discountDto;
	}

}