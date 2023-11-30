package com.recipemichael.recipemaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.recipemichael.recipemaker"})
public class RecipeMakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeMakerApplication.class, args);
	}

}
