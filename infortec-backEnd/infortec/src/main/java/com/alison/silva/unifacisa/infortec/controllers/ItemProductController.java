package com.alison.silva.unifacisa.infortec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alison.silva.unifacisa.infortec.services.ItemProductService;

@RestController
@RequestMapping("/itemProduct")
public class ItemProductController {
	@Autowired
	ItemProductService itemProductService;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteItemFindById(@PathVariable Long id){
		itemProductService.deletefindById(id);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(id);
		
	}
}
