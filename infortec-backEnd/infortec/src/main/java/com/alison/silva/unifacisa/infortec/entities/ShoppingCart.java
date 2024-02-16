package com.alison.silva.unifacisa.infortec.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy = "shoppingCart")
	private List<ItemProduct> items;
	
	@OneToOne
	private User client;
	
	public ShoppingCart () {}
	
	
	public ShoppingCart(User client) {
		super();
		this.client = client;
	}


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

	public Long getId() {
		return id;
	}
	
}
