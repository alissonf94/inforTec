package com.alison.silva.unifacisa.infortec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alison.silva.unifacisa.infortec.dto.PromotionMinDTO;
import com.alison.silva.unifacisa.infortec.dto.RegisterPromotionDTO;
import com.alison.silva.unifacisa.infortec.entities.Product;
import com.alison.silva.unifacisa.infortec.entities.Promotion;
import com.alison.silva.unifacisa.infortec.services.ProductService;
import com.alison.silva.unifacisa.infortec.services.PromotionService;

@RestController
@RequestMapping("promotions")
public class PromotionController {
	@Autowired
	PromotionService promotionService;
	
	@Autowired
	ProductService  productService;
	
	@PostMapping("/register")
	public ResponseEntity<Promotion> registerPromotion(@RequestBody RegisterPromotionDTO registerPromotionDTO){
		
		Product product = productService.findOneByName(registerPromotionDTO.nameProduct());
		product.setPricePromotion(registerPromotionDTO.pricePromotion());
		Promotion promotion = new Promotion(registerPromotionDTO.experionDate(), product);
		
		promotionService.registerPromotion(promotion);
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(promotion);
		
	}
	
	@GetMapping 
	public List<PromotionMinDTO> findAll(){
		return promotionService.findAll();
	}
}
