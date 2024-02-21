package com.alison.silva.unifacisa.infortec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alison.silva.unifacisa.infortec.repositories.ItemProductRepository;

@Service
public class ItemProductService {
	@Autowired
	ItemProductRepository itemProductRepository;
	
	
	public void deletefindById(Long id) 
	{
		itemProductRepository.deleteById(id);
	}
}
