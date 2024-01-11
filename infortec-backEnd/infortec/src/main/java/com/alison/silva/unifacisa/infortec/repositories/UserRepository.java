package com.alison.silva.unifacisa.infortec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.alison.silva.unifacisa.infortec.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
	UserDetails findByEmail (String email);
}
