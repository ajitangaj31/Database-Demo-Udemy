package com.ajitangaj.database.databasedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ajitangaj.database.databasedemo.repository.PersonJpaRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@SpringBootApplication
@RequiredArgsConstructor
@Getter
@Setter
public class DatabaseDemoApplication implements CommandLineRunner{
	
	public final PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var person = personJpaRepository.findById(1001);
		System.out.println(person);
	}

}
