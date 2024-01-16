package com.alison.silva.unifacisa.infortec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alison.silva.unifacisa.infortec.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	Product findOneByName(String name);
}
