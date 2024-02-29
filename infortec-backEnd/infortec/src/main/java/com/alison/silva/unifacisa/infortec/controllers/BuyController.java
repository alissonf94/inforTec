package com.alison.silva.unifacisa.infortec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alison.silva.unifacisa.infortec.dto.BuyMinDTO;
import com.alison.silva.unifacisa.infortec.dto.FindBuys;
import com.alison.silva.unifacisa.infortec.dto.RegisterBuy;
import com.alison.silva.unifacisa.infortec.services.BuyService;

@RestController
@RequestMapping("/buys")
public class BuyController {
	@Autowired
	BuyService buyService;
	
	@PostMapping
	public ResponseEntity<BuyMinDTO> registerBuy (@RequestBody RegisterBuy registerBuy ){
		return ResponseEntity.status(HttpStatus.CREATED).body(buyService.registerBuy(registerBuy));
	}
	
	@GetMapping("/{id}")
	public List<FindBuys> findBuysByIdClient (@PathVariable Long id){
		return buyService.findBuysByIdClient(id);
	}
}
