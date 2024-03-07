package com.alison.silva.unifacisa.infortec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alison.silva.unifacisa.infortec.dto.UpdateItemProduct;
import com.alison.silva.unifacisa.infortec.entities.ItemProduct;
import com.alison.silva.unifacisa.infortec.repositories.ItemProductRepository;

@Service
public class ItemProductService {
	@Autowired
	ItemProductRepository itemProductRepository;
	
	
	public void deletefindById(Long id) 
	{
		itemProductRepository.deleteById(id);
	}
	
	public ItemProduct updateQuantityProductById(UpdateItemProduct updateItemProduc) {
		
		ItemProduct itemProduct =  itemProductRepository.findById(updateItemProduc.idProduct()).orElse(null);
		
		Double newValueItem = itemProduct.getProduct().getPrice() * updateItemProduc.newQuantityProduct();
		itemProduct.setValueItem(newValueItem);
		itemProduct.setQuantityProduct(updateItemProduc.newQuantityProduct());
		
		itemProductRepository.save(itemProduct);
		
		return itemProduct;
		
	}
}
