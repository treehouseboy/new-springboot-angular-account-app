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

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	ApplicationRunner init(AccountRepository repository) {
		return args -> {
			Stream.of("Fred", "James", "Pam", "Larry", "Ben", "Anna", "Tilly", "Frances", "Carl")
					.forEach(firstName -> {
						Account account = new Account();
						account.setFirstName(firstName);
						repository.save(account);
					});
			repository.findAll().forEach(System.out::println);
		};
	}
}