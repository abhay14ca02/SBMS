package com.rajabhay.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.SneakyThrows;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager inMemoryUsers() {
		
		UserDetails user1 = User.withDefaultPasswordEncoder()
							 .username("abc")
							 .password("abc@123")
							 .build();
		
		UserDetails user2 = User.withDefaultPasswordEncoder()
							 .username("raju")
							 .password("raju@123")
							 .build();
		
		UserDetails user3 = User.withDefaultPasswordEncoder()
							 .username("john")
							 .password("john@123")
							 .build();
		
		return new InMemoryUserDetailsManager(user1, user2, user3);
	}
	
	@Bean
	@SneakyThrows
	public SecurityFilterChain security(HttpSecurity security) {

		security.authorizeHttpRequests(
				(req) -> req.requestMatchers("/contact").permitAll().anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());

		return security.build();

	}
}
