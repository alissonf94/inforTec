package com.alison.silva.unifacisa.infortec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alison.silva.unifacisa.infortec.entities.Favorite;
import com.alison.silva.unifacisa.infortec.entities.Product;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>{
	 Favorite findByProduct (Product product);
}
