package com.alison.silva.unifacisa.infortec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alison.silva.unifacisa.infortec.entities.ShoppingCart;
import com.alison.silva.unifacisa.infortec.repositories.ShoppingCartRepository;


@Service
public class ShoppingCartService {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	public List< ShoppingCart> findShoppingCartByIdClient(Long id) {
		List <ShoppingCart> shoppingCart = shoppingCartRepository.findAll().stream().filter(p -> p.getClient().getId().equals(id)).toList();
		return shoppingCart;
	}
}
