package com.alison.silva.unifacisa.infortec.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	private Integer quantityProduct;
	private Double valueItem;
	
	@ManyToOne
	@JoinColumn(name = "shoppingCart_id")
	private ShoppingCart shoppingCart;
	
	public ItemProduct() {
		
	}

	public ItemProduct(Product product, Integer quantityProduct, Double valueItem, ShoppingCart shoppingCart) {
		this.product = product;
		this.quantityProduct = quantityProduct;
		this.valueItem = valueItem;
		this.shoppingCart = shoppingCart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(Integer quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public Double getValueItem() {
		return valueItem;
	}

	public void setValueItem(Double valueItem) {
		this.valueItem = valueItem;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public Long getId() {
		return id;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
}
