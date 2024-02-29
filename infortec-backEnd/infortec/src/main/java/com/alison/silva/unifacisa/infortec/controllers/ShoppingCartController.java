package com.alison.silva.unifacisa.infortec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alison.silva.unifacisa.infortec.dto.ItemProductMinDTO;
import com.alison.silva.unifacisa.infortec.dto.RegisterItemProduct;
import com.alison.silva.unifacisa.infortec.dto.ShoppingCartMinDTO;
import com.alison.silva.unifacisa.infortec.services.ShoppingCartService;

@RestController
@RequestMapping("shoppingCarts")
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ShoppingCartMinDTO> findShoppingCartByEmailUser (@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(shoppingCartService.findShoppingCartByIdClient(id));
	}
	
	@PutMapping
	public ResponseEntity<ItemProductMinDTO> addItemProduct(@RequestBody RegisterItemProduct registerItemProduct){
		return ResponseEntity.status(HttpStatus.CREATED).body(shoppingCartService.addItemProduct(registerItemProduct));
	}
}
