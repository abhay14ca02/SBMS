package com.rajabhay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rajabhay.appsecurity.AppSecurity;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig :: Constructor");
	}

    @Bean
    AppSecurity getInstance() {
		return new AppSecurity();
	}
}
