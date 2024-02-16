package com.alison.silva.unifacisa.infortec.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Buy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	private List<ItemProduct> items;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	private Double valueBuy;
	
	public Buy  () {}
	
	public Buy(List<ItemProduct> items, User client, Double valueBuy) {
		this.items = items;
		this.client = client;
		this.valueBuy = valueBuy;
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
	
	public Double getValueBuy() {
		return valueBuy;
	}
	public void setValueBuy(Double valueBuy) {
		this.valueBuy = valueBuy;
	}
	
	
}
