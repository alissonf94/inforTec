package com.alison.silva.unifacisa.infortec.entities;

public class ItemProduct {
	private Product product;
	private Integer quantityProduct;
	private Double valueItem;
	private ShoppingCart shoppingCart;
	private Buy buy;
	
	public ItemProduct() {
		
	}

	public ItemProduct(Product product, Integer quantityProduct, Double valueItem) {
		this.product = product;
		this.quantityProduct = quantityProduct;
		this.valueItem = valueItem;
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

	public Buy getBuy() {
		return buy;
	}

	public void setBuy(Buy buy) {
		this.buy = buy;
	}
	
	
}
