package com.rajabhay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.rajabhay.service.CustomerService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	private CustomerService customerService;

	public AppSecurityConfig(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public AuthenticationProvider authProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(customerService);
		authProvider.setPasswordEncoder(pwdEncoder());
		return authProvider;
	}

	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(req -> {
			req.requestMatchers("/register", "/login").permitAll().anyRequest().authenticated();
		});

		http.csrf(csrf -> csrf.disable());

		return http.build();
	}
}
