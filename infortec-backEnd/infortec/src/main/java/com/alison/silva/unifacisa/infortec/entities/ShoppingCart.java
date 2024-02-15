package com.alison.silva.unifacisa.infortec.entities;

import java.util.List;


public class ShoppingCart {
	
	private List<ItemProduct> items;
	private User client;
	
	public ShoppingCart () {}
	
	public List<ItemProduct> getItems() {
		return items;
	}
	public void setItems(List<ItemProduct> items) {
		this.items = items;
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
}
