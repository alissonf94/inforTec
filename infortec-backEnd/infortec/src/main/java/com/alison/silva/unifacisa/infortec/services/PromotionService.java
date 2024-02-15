package com.alison.silva.unifacisa.infortec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.alison.silva.unifacisa.infortec.dto.PromotionMinDTO;
import com.alison.silva.unifacisa.infortec.entities.Promotion;
import com.alison.silva.unifacisa.infortec.repositories.ProductRepository;
import com.alison.silva.unifacisa.infortec.repositories.PromotionRepository;

@Service
public class PromotionService {
	
	@Autowired
	PromotionRepository promotionRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public Promotion registerPromotion(Promotion promotion) {
		Promotion verifyPromotion = promotionRepository.findOneById(promotion.getId());
		
		if(verifyPromotion != null) {
			throw new DataIntegrityViolationException("Promotion already exist");
		}
		
		promotionRepository.save(promotion);
		return promotion;
	}
	
	public List<PromotionMinDTO> findAll() {
		List<Promotion> promotions = promotionRepository.findAll();
		List<PromotionMinDTO> dtos = promotions.stream().map(p -> new PromotionMinDTO(p)).toList();
		return dtos;
	}
}
