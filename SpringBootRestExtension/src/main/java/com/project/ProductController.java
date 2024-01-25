package com.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("updateProduct")
	public String updateEntry(@RequestBody Product product) {
		try {
			return productService.updateProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "No Product found";
	}

	@PostMapping("productDiscount")
	public DiscountDto updateDiscount(@RequestBody Discount discount) {

		return productService.updateProductDiscount(discount);
	}

	@DeleteMapping("deleteProduct/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		String deleteMessage = "";
		try {
			deleteMessage = productService.deleteProductById(id);
		} catch (Exception e) {
			e.printStackTrace();
			deleteMessage = "Error deleting purchase entry";
		}
		return deleteMessage;
	}

	@PostMapping("/createProduct")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@GetMapping("/getProduct/{id}")
	public Product createProduct(@PathVariable Integer id) {
		return productService.getProductById(id);
	}

}
