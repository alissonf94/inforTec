package com.alison.silva.unifacisa.infortec.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alison.silva.unifacisa.infortec.dto.BuyMinDTO;
import com.alison.silva.unifacisa.infortec.dto.FindBuys;
import com.alison.silva.unifacisa.infortec.dto.ItemProductMinDTO;
import com.alison.silva.unifacisa.infortec.dto.RegisterBuy;
import com.alison.silva.unifacisa.infortec.entities.Buy;
import com.alison.silva.unifacisa.infortec.entities.ItemProduct;
import com.alison.silva.unifacisa.infortec.entities.ShoppingCart;
import com.alison.silva.unifacisa.infortec.entities.User;
import com.alison.silva.unifacisa.infortec.repositories.BuyRepository;
import com.alison.silva.unifacisa.infortec.repositories.ItemProductRepository;
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
	
	@Autowired
	ItemProductRepository itemProductRepository;
	
	public BuyMinDTO registerBuy (RegisterBuy registerBuy) {
		User client = (User) userRepository.findByEmail(registerBuy.emailClient());
		ShoppingCart shoppingCart = shoppingCartRepository.findByClient(client);
		List<ItemProduct> itens = shoppingCart.getItems();
		
		Double valueBuy = itens.stream().mapToDouble(p-> p.getValueItem()).sum();
	
		Buy buy = new Buy(client, valueBuy);
		itens.stream().map(p-> buy.getItems().add(p)).toList();
		
		buyRepository.save(buy);
		client.getBuys().add(buy);
		
		List<ItemProductMinDTO> dtos = itens.stream().map(p-> new ItemProductMinDTO(p)).toList();
		BuyMinDTO buyMinDTO = new BuyMinDTO(dtos, client.getId(), valueBuy);
		
		itens.forEach(p-> p.setShoppingCart(null));
		
		shoppingCart.getItems().clear();
		shoppingCartRepository.save(shoppingCart);
		
		return buyMinDTO;
	}
	
	public List<FindBuys> findBuysByIdClient (Long idClient){
		User client = (User) userRepository.findById(idClient).orElse(null);
		
		List<Buy> buys = buyRepository.findByClient(client);
		
		Integer quantityProduct = buys.stream().mapToInt(p -> p.getItems().size() ).sum();
		
		List<FindBuys> result = buys.stream().map(p -> new FindBuys(quantityProduct, idClient, p.getValueBuy() )).toList();
		
		return result;
	}	
}
