package com.alison.silva.unifacisa.infortec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alison.silva.unifacisa.infortec.dto.FavoriteMinDTO;
import com.alison.silva.unifacisa.infortec.dto.RegisterFavoriteDTO;
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
	
	@DeleteMapping("/{idProduct}")
	public ResponseEntity<Long> deleteByIdProduct (@PathVariable Long idProduct) {
		
		favoriteService.deleteByIdPrduct(idProduct);
		return ResponseEntity.status(HttpStatus.OK).body(idProduct);
		
	}
	
	@DeleteMapping
	public ResponseEntity<Long> deleteById (@RequestParam Long idFavorite)
	{
		favoriteService.deleteById(idFavorite);
		return ResponseEntity.status(HttpStatus.OK).body(idFavorite);
	}
		
	
	@GetMapping("/check")
	public ResponseEntity<Boolean> verifyProductInFavorites (@RequestParam Long idProduct, @RequestParam Long idClient){
		Boolean result = favoriteService.verifyProductInFavoritesByClient(idProduct, idClient);
		return  ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("/{idClient}")
	public List<FavoriteMinDTO> findAll (@PathVariable Long idClient){
		return favoriteService.findAll(idClient);
	}
}
