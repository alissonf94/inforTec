package com.alison.silva.unifacisa.infortec.infra.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

	@Autowired
	SecurityFilter securityFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
		return httpSecurity.csrf(csrf -> csrf.disable()).sessionManagement(
				session -> session.sessionCreationPolicy(
						SessionCreationPolicy.STATELESS)).authorizeHttpRequests(authorize -> 
						authorize.requestMatchers(HttpMethod.POST, "/auth/register").permitAll().requestMatchers(HttpMethod.POST,"/auth/login").permitAll().
						requestMatchers(HttpMethod.POST, "products/register").permitAll().requestMatchers(HttpMethod.POST, "/promotions/register").permitAll().
						requestMatchers(HttpMethod.GET, "/products/{category}").permitAll().
						requestMatchers(HttpMethod.GET,"/promotions" ).permitAll().requestMatchers(HttpMethod.GET, "/shoppingCarts/{id}").permitAll().
						requestMatchers(HttpMethod.PUT, "/shoppingCarts").permitAll().requestMatchers(HttpMethod.DELETE,"/itemProduct/{id}").permitAll()
						.requestMatchers(HttpMethod.POST,"/buys").permitAll().requestMatchers(HttpMethod.GET,"/buys/{id}").permitAll().
						requestMatchers(HttpMethod.PUT,"/itemProduct").permitAll().requestMatchers(HttpMethod.POST, "/favorites").permitAll().
						anyRequest().authenticated())

				.addFilterBefore(securityFilter,UsernamePasswordAuthenticationFilter.class).build();	
		}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
	
}
