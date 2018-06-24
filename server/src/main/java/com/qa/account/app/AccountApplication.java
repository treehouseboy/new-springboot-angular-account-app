package com.qa.account.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class AccountApplication {
	private Account account;
	private String firstName[] = {"Fred", "James", "Pam"};
	private String lastName[] = {"Hardy", "Martin", "Atwood"};
	private String accountNumber[] = {"1234", "1235", "1236"};
	

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	ApplicationRunner init(AccountRepository repository) {
		return args -> {
//			Stream.of("Fred", "James", "Pam")
//					.forEach(firstName -> {
//						Account account = new Account();
//						account.setFirstName(firstName);
//						repository.save(account);
//					});
			for(int i = 0; i < 3; i++) {
				account = new Account();
				account.setFirstName(firstName[i]);
				account.setLastName(lastName[i]);
				account.setAccountNumber(accountNumber[i]);
				repository.save(account);	
			}
			repository.findAll().forEach(System.out::println);
		};
	}
}