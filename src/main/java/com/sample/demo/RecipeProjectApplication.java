package com.sample.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Contains methods to perform starting point of application excecution and
 * Swagger Document Mapping
 * 
 * @author Vidya sagar
 */
@SpringBootApplication
@EnableSwagger2
@EnableWebSecurity
public class RecipeProjectApplication {

	/**
	 * Execution of the Spring boot application starts here
	 */
	public static void main(String[] args) {
		SpringApplication.run(RecipeProjectApplication.class, args);
	}

	
	/**
	 * Swagger doc is generated using Docket and also configures with APi's related
	 * packages
	 * 
	 */
	@Bean
	public Docket recipeApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sample.demo.controller")).build();
	}

}
