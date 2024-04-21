package com.RNE.demande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.RNE.demande")
public class SelDemandeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelDemandeApiApplication.class, args);
	}

}
