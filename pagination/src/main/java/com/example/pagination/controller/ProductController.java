package com.example.pagination.controller;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagination.service.ProductService;
import com.example.pagination.model.*;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/page")
	public Page<Product> getProducts(
			@RequestParam int page,
			@RequestParam int size){
		return service.getProducts(page, size);
	}
	
	@GetMapping("/page-sort")
	public Page<Product> getProductsSorted(
			@RequestParam int page,
			@RequestParam int size,
			@RequestParam String field,
			@RequestParam String direction){
		return service.getProductsWithSort(page ,size ,field,direction);
	}
	
	

}
