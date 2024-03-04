package com.alison.silva.unifacisa.infortec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alison.silva.unifacisa.infortec.dto.AuthenticationDTO;
import com.alison.silva.unifacisa.infortec.dto.LoginResponseDTO;
import com.alison.silva.unifacisa.infortec.dto.RegisterUserDTO;
import com.alison.silva.unifacisa.infortec.dto.UserMinDTO;
import com.alison.silva.unifacisa.infortec.entities.ShoppingCart;
import com.alison.silva.unifacisa.infortec.entities.User;
import com.alison.silva.unifacisa.infortec.infra.security.TokenService;
import com.alison.silva.unifacisa.infortec.repositories.ShoppingCartRepository;
import com.alison.silva.unifacisa.infortec.services.AuthenticationService;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthenticationDTO data) {
		UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		
		var auth = this.authenticationManager.authenticate(usernamePassword);
		var token = tokenService.generateToken((User) auth.getPrincipal());
		User client = (User) authenticationService.loadUserByUsername(data.email());
		
		return ResponseEntity.ok(new LoginResponseDTO(token,new UserMinDTO(client.getName(), client.getEmail(), client.getId())));
	}
	
	@PostMapping("/register")
	public ResponseEntity<RegisterUserDTO> register (@RequestBody RegisterUserDTO register) {
		
		String encryptedPassword =  new BCryptPasswordEncoder().encode(register.password());
		
		User user = new User(register.name(), register.cpf(), register.email(), encryptedPassword, register.role());
		
		ShoppingCart shoppingCart = new ShoppingCart(user);
		user.setShoppingCart(shoppingCart);
		
		authenticationService.register(user);
		
	
		return ResponseEntity.status(HttpStatus.CREATED).body(register);
		
	}

}
