package com.alison.silva.unifacisa.infortec.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alison.silva.unifacisa.infortec.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	Product findByName(String name);
	List<Product> findByCategory(String category);
}
