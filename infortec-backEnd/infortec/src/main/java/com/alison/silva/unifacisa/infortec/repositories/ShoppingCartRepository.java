package com.alison.silva.unifacisa.infortec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alison.silva.unifacisa.infortec.entities.ShoppingCart;
import com.alison.silva.unifacisa.infortec.entities.User;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
	ShoppingCart findByClient(User client);
}
