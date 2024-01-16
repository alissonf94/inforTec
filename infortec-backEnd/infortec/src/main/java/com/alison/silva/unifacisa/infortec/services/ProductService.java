package com.alison.silva.unifacisa.infortec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.alison.silva.unifacisa.infortec.entities.Product;
import com.alison.silva.unifacisa.infortec.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public Product registerProduct(Product product) {

		Product verifyProduct = productRepository.findOneByName(product.getName());

		if (verifyProduct != null) {
			throw new DataIntegrityViolationException("Product already exist");
		}

		productRepository.save(product);
		return product;

	}
}
