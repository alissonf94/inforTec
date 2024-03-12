package com.alison.silva.unifacisa.infortec.dto;

import java.util.List;

import com.alison.silva.unifacisa.infortec.entities.ShoppingCart;

public class ShoppingCartMinDTO {
	private Long idShoppingCart;
	private List<ItemProductMinDTO> itens;
	private Long idClient;
	private String emailClient;
	private Double valueBuy;
	
	public ShoppingCartMinDTO(ShoppingCart shoppingCart, Double valueBuy) {
		this.idShoppingCart =  shoppingCart.getId();
		this.idClient = shoppingCart.getClient().getId();
		this.emailClient = shoppingCart.getClient().getEmail();
		this.valueBuy = valueBuy;
	}

	public Long getIdShoppingCart() {
		return idShoppingCart;
	}

	public List<ItemProductMinDTO> getItens() {
		return itens;
	}
	
	public Long getIdClient() {
		return idClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setItens(List<ItemProductMinDTO> itens) {
		this.itens = itens;
	}
	
	public Double getValueBuy () {
		return valueBuy;
	}
	
}
