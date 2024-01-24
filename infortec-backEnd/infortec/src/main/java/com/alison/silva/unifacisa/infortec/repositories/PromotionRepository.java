package com.alison.silva.unifacisa.infortec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alison.silva.unifacisa.infortec.entities.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
	Promotion findOneById (Long id);
}
