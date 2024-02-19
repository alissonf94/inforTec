package com.alison.silva.unifacisa.infortec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alison.silva.unifacisa.infortec.dto.ItemProductMinDTO;
import com.alison.silva.unifacisa.infortec.dto.RegisterItemProduct;
import com.alison.silva.unifacisa.infortec.dto.ShoppingCartMinDTO;
import com.alison.silva.unifacisa.infortec.entities.ItemProduct;
import com.alison.silva.unifacisa.infortec.entities.Product;
import com.alison.silva.unifacisa.infortec.entities.ShoppingCart;
import com.alison.silva.unifacisa.infortec.repositories.ItemProductRepository;
import com.alison.silva.unifacisa.infortec.repositories.ProductRepository;
import com.alison.silva.unifacisa.infortec.repositories.ShoppingCartRepository;


@Service
public class ShoppingCartService {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	ItemProductRepository itemProductRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public ShoppingCartMinDTO findShoppingCartByIdClient(Long id) {
		ShoppingCart shoppingCart = shoppingCartRepository.findAll().stream().filter(p -> p.getClient().getId().equals(id)).findFirst().orElse(null);
		ShoppingCartMinDTO cartMinDTO = new ShoppingCartMinDTO(shoppingCart);
		
		List<ItemProductMinDTO> dtos = shoppingCart.getItems().stream().map(p-> new ItemProductMinDTO(p)).toList();
		cartMinDTO.setItens(dtos);
		
		return cartMinDTO;
	}
	
	
	public ItemProduct addItemProduct (RegisterItemProduct registerItemProduct) {
		Product product = productRepository.findOneByName(registerItemProduct.nameProduct());
		ShoppingCart shoppingCart = shoppingCartRepository.findAll().stream().filter(p -> p.getClient().getId().equals(registerItemProduct.idClient())).findFirst().orElse(null);
		Double valueItem = product.getPrice() * registerItemProduct.quantityProduct();
		ItemProduct itemProduct = new ItemProduct(product, registerItemProduct.quantityProduct(),valueItem, shoppingCart);
		itemProductRepository.save(itemProduct);
		
		shoppingCart.getItems().add(itemProduct);
		shoppingCartRepository.save(shoppingCart);
		
		return itemProduct;
		
	}
}
