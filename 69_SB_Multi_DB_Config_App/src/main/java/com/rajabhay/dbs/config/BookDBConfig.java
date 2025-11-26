package com.rajabhay.dbs.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "bookEntityManagerFactory", 
		transactionManagerRef = "bookTransactionManager", 
		basePackages = {
				"com.rajabhay.book.repo"
		}
)
public class BookDBConfig {

	@Bean(name = "bookDataSource")
	@ConfigurationProperties(prefix = "spring.book.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "bookEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("bookDataSource") DataSource dataSource) {
		
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		return builder.dataSource(dataSource)
					  .properties(properties)
					  .packages("com.rajabhay.book.entity")
					  .persistenceUnit("Book")
					  .build();
	}

	@Bean(name = "bookTransactionManager")
	public PlatformTransactionManager bookTransactionManager(@Qualifier("bookEntityManagerFactory") EntityManagerFactory bookEntityManagerFactory) {
		return new JpaTransactionManager(bookEntityManagerFactory);
	}
}