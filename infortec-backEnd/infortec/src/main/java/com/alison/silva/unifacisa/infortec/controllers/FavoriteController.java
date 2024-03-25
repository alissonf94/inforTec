package com.alison.silva.unifacisa.infortec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alison.silva.unifacisa.infortec.dto.FavoriteMinDTO;
import com.alison.silva.unifacisa.infortec.dto.RegisterFavoriteDTO;
import com.alison.silva.unifacisa.infortec.entities.Favorite;
import com.alison.silva.unifacisa.infortec.services.FavoriteService;

@RestController
@RequestMapping("favorites")
public class FavoriteController {
	@Autowired 
	FavoriteService favoriteService;
	
	@PostMapping
	public ResponseEntity<FavoriteMinDTO> insertFavorite (@RequestBody RegisterFavoriteDTO registerFavoriteDTO){
		FavoriteMinDTO favorite = favoriteService.insertFavorite(registerFavoriteDTO.idClient(),registerFavoriteDTO.idProduct());
		return ResponseEntity.status(HttpStatus.CREATED).body(favorite);
	}
}
