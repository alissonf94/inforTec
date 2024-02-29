package com.alison.silva.unifacisa.infortec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alison.silva.unifacisa.infortec.entities.Buy;
import com.alison.silva.unifacisa.infortec.entities.User;

public interface BuyRepository extends JpaRepository<Buy, Long> {
	List<Buy> findByClient(User Client);
}
