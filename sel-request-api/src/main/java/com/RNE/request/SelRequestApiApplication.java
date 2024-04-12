package com.RNE.request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.RNE.request")
public class SelRequestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelRequestApiApplication.class, args);
	}

}
