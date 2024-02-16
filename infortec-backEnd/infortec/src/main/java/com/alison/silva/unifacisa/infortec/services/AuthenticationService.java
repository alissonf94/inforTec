package com.alison.silva.unifacisa.infortec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alison.silva.unifacisa.infortec.entities.User;
import com.alison.silva.unifacisa.infortec.repositories.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	
	public User register (User user) {
		return userRepository.save(user);
	}
}
