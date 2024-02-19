package com.alison.silva.unifacisa.infortec.dto;

import com.alison.silva.unifacisa.infortec.entities.ItemProduct;
import com.alison.silva.unifacisa.infortec.entities.Product;

public class ItemProductMinDTO {
	private Long id;
	private Product product;
	private Integer quantityProduct;
	private Double valueItem;
	
	public ItemProductMinDTO(ItemProduct itemProduct) {
		super();
		this.id =  itemProduct.getId();
		this.product = itemProduct.getProduct();
		this.quantityProduct =  itemProduct.getQuantityProduct();
		this.valueItem = itemProduct.getValueItem();
	}

	public Long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public Integer getQuantityProduct() {
		return quantityProduct;
	}

	public Double getValueItem() {
		return valueItem;
	}
	
	
}
