package com.alison.silva.unifacisa.infortec.dto;

import com.alison.silva.unifacisa.infortec.entities.Promotion;

public class PromotionMinDTO {
	private String nameProduct;
	private Double price;
	private Double pricePromotion;
	private String imgUrl;
	
	public PromotionMinDTO(Promotion promotion) {
		this.nameProduct = promotion.getProduct().getName();
		this.price = promotion.getProduct().getPrice();
		this.pricePromotion = promotion.getProduct().getPricePromotion();
		this.imgUrl = promotion.getProduct().getImgUrl();
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPricePromotion() {
		return pricePromotion;
	}

	public void setPricePromotion(Double pricePromotion) {
		this.pricePromotion = pricePromotion;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
