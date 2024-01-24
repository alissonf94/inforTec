package com.alison.silva.unifacisa.infortec.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date experionDate;
	
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public Promotion() {}
	
	public Promotion(Date experionDate, Product product) {
		super();
		this.experionDate = experionDate;
		this.product = product;
	}

	public Date getExperionDate() {
		return experionDate;
	}

	public void setExperionDate(Date experionDate) {
		this.experionDate = experionDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getId() {
		return id;
	}
	
	
}
