package com.example.be_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.example.be_project.model")
@SpringBootApplication
public class BeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeProjectApplication.class, args);
	}

}
