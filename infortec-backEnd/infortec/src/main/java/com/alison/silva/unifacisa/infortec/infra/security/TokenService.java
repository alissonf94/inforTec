package com.alison.silva.unifacisa.infortec.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alison.silva.unifacisa.infortec.entities.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class TokenService {
	@Value("${api.security.token.secret}") 
	private String secret;
	
	public String generateToken(User user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create().withIssuer("infortec").withSubject(secret).withSubject(user.getEmail())
					.withExpiresAt(genExperirationDate()).sign(algorithm);
			return token;
		}
		catch(JWTCreationException e) {
			throw new RuntimeException("Error while generating token," + e);
		}
	}
	
	private Instant genExperirationDate()
	{
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer("Sistema").build().verify(token).getSubject();
		} 
		catch (Exception e) {
			
			return "";
		}
	}
}
