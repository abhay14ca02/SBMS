package com.rajabhay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rajabhay.service.TxService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		// PersonService personService = context.getBean(PersonService.class);
		// personService.savePersons();
		// personService.getPersonsSort();
		// personService.getPersonsPagination();
		// personService.getPersonsQBE("Male", "India");
		// ContactService contactService = context.getBean(ContactService.class);
		// contactService.savContactInfo();
		TxService txService = context.getBean(TxService.class);
		txService.savePersonWithContact();
	}

}
