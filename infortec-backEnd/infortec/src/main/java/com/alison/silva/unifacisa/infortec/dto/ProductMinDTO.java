package com.alison.silva.unifacisa.infortec.dto;

import com.alison.silva.unifacisa.infortec.entities.Product;

public class ProductMinDTO{
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl; 
	private String brand; 
	private String category;
	
	public ProductMinDTO(Product product) {
		super();
		this.id = product.getId();
		this.name =product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.imgUrl = product.getImgUrl();
		this.brand = product.getBrand();
		this.category = product.getCategory();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getBrand() {
		return brand;
	}

	public String getCategory() {
		return category;
	}
	

}
