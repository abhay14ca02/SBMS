package com.rajabhay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rajabhay.security.AppSecurity;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig :: Constructor...");

	}

	// Programmer is creating object for AppSecurity class not IOC. IOC is calling
	// method only
	// We use @Bean annotation, when we need to manage Security implementation
	@Bean
	public AppSecurity getInstance() {
		return new AppSecurity();
	}
}
