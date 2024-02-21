package com.alison.silva.unifacisa.infortec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alison.silva.unifacisa.infortec.dto.BuyMinDTO;
import com.alison.silva.unifacisa.infortec.dto.ItemProductMinDTO;
import com.alison.silva.unifacisa.infortec.dto.RegisterBuy;
import com.alison.silva.unifacisa.infortec.entities.Buy;
import com.alison.silva.unifacisa.infortec.entities.ItemProduct;
import com.alison.silva.unifacisa.infortec.entities.ShoppingCart;
import com.alison.silva.unifacisa.infortec.entities.User;
import com.alison.silva.unifacisa.infortec.repositories.BuyRepository;
import com.alison.silva.unifacisa.infortec.repositories.ShoppingCartRepository;
import com.alison.silva.unifacisa.infortec.repositories.UserRepository;

@Service
public class BuyService {
	@Autowired
	BuyRepository buyRepository;
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public BuyMinDTO registerBuy (RegisterBuy registerBuy) {
		ShoppingCart shoppingCart = shoppingCartRepository.findAll().stream().filter(p -> p.getClient().getEmail().equals(registerBuy.emailClient())).findFirst().orElse(null);
		List<ItemProduct> itens = shoppingCart.getItems();
		Double valueBuy = itens.stream().mapToDouble(p-> p.getValueItem()).sum();
		
		User client = (User) userRepository.findByEmail(registerBuy.emailClient());
		
		Buy buy = new Buy(itens, client, valueBuy);
		buyRepository.save(buy);
		
		client.getBuys().add(buy);
		
		List<ItemProductMinDTO> dtos = itens.stream().map(p-> new ItemProductMinDTO(p)).toList();
		
		BuyMinDTO buyMinDTO = new BuyMinDTO(dtos, client.getId(), valueBuy);
		
		return buyMinDTO;
	}
}
