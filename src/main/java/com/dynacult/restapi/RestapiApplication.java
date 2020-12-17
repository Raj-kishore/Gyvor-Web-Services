package com.dynacult.restapi;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
public class RestapiApplication {


	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}
	
	@Bean
	public Docket productApi() {
	   return new Docket(DocumentationType.SWAGGER_2).select()
	      .apis(RequestHandlerSelectors.basePackage("com.dynacult.restapi")).build();
	}
	
}


/****
 * References :
 * 
 * Main project : https://www.dariawan.com/tutorials/spring/spring-boot-jpa-hibernate-postgresql-restful-crud-api-example/
 *  
 * JWT : https://www.javainuse.com/spring/boot-jwt 
 *  
 */




	

