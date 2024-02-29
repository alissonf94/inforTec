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
import com.alison.silva.unifacisa.infortec.entities.User;
import com.alison.silva.unifacisa.infortec.repositories.ItemProductRepository;
import com.alison.silva.unifacisa.infortec.repositories.ProductRepository;
import com.alison.silva.unifacisa.infortec.repositories.ShoppingCartRepository;
import com.alison.silva.unifacisa.infortec.repositories.UserRepository;

@Service
public class ShoppingCartService {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	ItemProductRepository itemProductRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	public ShoppingCartMinDTO findShoppingCartByIdClient(Long id) {
		User client = userRepository.findById(id).orElse(null);
		
		ShoppingCart shoppingCart = shoppingCartRepository.findByClient(client);
		ShoppingCartMinDTO cartMinDTO = new ShoppingCartMinDTO(shoppingCart);
		
		List<ItemProductMinDTO> dtos = shoppingCart.getItems().stream().map(p-> new ItemProductMinDTO(p)).toList();
		cartMinDTO.setItens(dtos);
		
		return cartMinDTO;
	}
	
	
	public ItemProductMinDTO addItemProduct (RegisterItemProduct registerItemProduct) {
		Product product = productRepository.findByName(registerItemProduct.nameProduct());
		
		User client = userRepository.findById(registerItemProduct.idClient()).orElse(null);
		ShoppingCart shoppingCart = shoppingCartRepository.findByClient(client);
		
		
		Double valueItem = product.getPrice() * registerItemProduct.quantityProduct();
		ItemProduct itemProduct = new ItemProduct(product, registerItemProduct.quantityProduct(),valueItem, shoppingCart);
		
		ItemProduct verify = verifyItemProduct(shoppingCart.getItems(), registerItemProduct.nameProduct(), registerItemProduct.quantityProduct());
		
		if(verify != null) {
			return new ItemProductMinDTO(verify);
		}
		
		else {
			itemProductRepository.save(itemProduct);
			
			shoppingCart.getItems().add(itemProduct);
			shoppingCartRepository.save(shoppingCart);
			
			return new ItemProductMinDTO(itemProduct);
		}
		
	}
	
	private ItemProduct verifyItemProduct(List<ItemProduct> itens, String nameProduct, Integer quantityProdutc) {
		ItemProduct itemProduct = itens.stream().filter(p -> p.getProduct().getName().equals(nameProduct)).findFirst().orElse(null);
		
		if(itemProduct != null) {
			itemProduct.setQuantityProduct(itemProduct.getQuantityProduct() + quantityProdutc );
			itemProductRepository.save(itemProduct);
			
			return itemProduct;
		}
		
		return null;
		
	}
}
