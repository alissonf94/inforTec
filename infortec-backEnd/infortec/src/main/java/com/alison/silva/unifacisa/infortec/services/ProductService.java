package com.alison.silva.unifacisa.infortec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.alison.silva.unifacisa.infortec.dto.ProductMinDTO;
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
	
	public Product findOneByName(String name) {
		Product product = productRepository.findOneByName(name);
	
		return product;
	}
	
	public List<ProductMinDTO> findByCategory(String category){
		List<Product> products =  productRepository.findAll();
		
		List<Product> productsByCategory = products.stream().filter(p -> p.getCategory().equals(category)).toList();
		
		List<ProductMinDTO> dtos = productsByCategory.stream().map(p -> new ProductMinDTO(p)).toList();
		
		return dtos;
	}
}
