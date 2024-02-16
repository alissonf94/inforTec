package com.alison.silva.unifacisa.infortec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alison.silva.unifacisa.infortec.entities.ShoppingCart;
import com.alison.silva.unifacisa.infortec.services.ShoppingCartService;

@RestController
@RequestMapping("shoppingCarts")
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@GetMapping("/{id}")
	public List<ShoppingCart> findShoppingCartByEmailUser (@PathVariable Long id) {
		return shoppingCartService.findShoppingCartByIdClient(id);
	}
	
}
