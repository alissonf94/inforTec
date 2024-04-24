package com.alison.silva.unifacisa.infortec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.alison.silva.unifacisa.infortec.dto.FavoriteMinDTO;
import com.alison.silva.unifacisa.infortec.dto.ProductMinDTO;
import com.alison.silva.unifacisa.infortec.entities.Favorite;
import com.alison.silva.unifacisa.infortec.entities.Product;
import com.alison.silva.unifacisa.infortec.entities.User;
import com.alison.silva.unifacisa.infortec.repositories.FavoriteRepository;
import com.alison.silva.unifacisa.infortec.repositories.ProductRepository;
import com.alison.silva.unifacisa.infortec.repositories.UserRepository;
import com.alison.silva.unifacisa.infortec.services.exceptions.ObjectNotFoundException;

@Service
public class FavoriteService {
	
	@Autowired
	FavoriteRepository favoriteRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	public FavoriteMinDTO insertFavorite (Long idClient, Long idProduct) {
		User client = userRepository.findById(idClient).orElse(null);
		
		Product product = productRepository.findById(idProduct).orElse(null);
		
		if(product == null || client == null) {
			throw new ObjectNotFoundException("Product or client not found");
		}
		
		if(favoriteRepository.findByProduct(product) != null) {
			throw new DataIntegrityViolationException("The product already exists in the favorites list");
		}
		
		Favorite favorite = new Favorite(product, client);
		
		client.getFavorites().add(favorite);
		userRepository.save(client);
		
		ProductMinDTO productMinDTO = new ProductMinDTO(product);
		
	 favoriteRepository.save(favorite);
	 return new FavoriteMinDTO(productMinDTO, idClient);
	 
	}
	
	public void deleteById (Long idProduct) {
		Favorite favorite =  favoriteRepository.findAll().stream().filter(p -> p.getProduct().getId().equals(idProduct)).findFirst().orElse(null);
		favoriteRepository.deleteById(favorite.getId());
	}
	
	public Boolean verifyProductInFavoritesByClient (Long idProduct, Long idClient) {
		Product product = productRepository.findById(idProduct).orElse(null);
		Favorite favorite = favoriteRepository.findByProduct(product);
		User user = userRepository.findById(idClient).orElse(null);
		
		if(favorite!= null) {
			return  favorite.getClient().equals(user) ? true : false;
		}
		
		return false;
		
		
	}
}
