package com.kevincode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArquitectApplication {

	public static void main(String[] args) {
		System.out.println("===================================================================================");
		System.out.println("===================================================================================");
		System.out.println("===================================================================================");
		System.out.println("===================================================================================");

		System.out.println("Valor de SPRING_DATASOURCE_URL: " + System.getenv("SPRING_DATASOURCE_URL"));
		SpringApplication.run(ArquitectApplication.class, args);
	}

}
