package com.alison.silva.unifacisa.infortec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alison.silva.unifacisa.infortec.dto.ResgisterProductDTO;
import com.alison.silva.unifacisa.infortec.entities.Product;
import com.alison.silva.unifacisa.infortec.services.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping("/register")
	public ResponseEntity<Product> registerProduct( @RequestBody ResgisterProductDTO registerProduct){
		Product product = new Product(registerProduct.name(), registerProduct.description(), registerProduct.price(), registerProduct.imgUrl(),registerProduct.brand() );
		
		productService.registerProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

}
