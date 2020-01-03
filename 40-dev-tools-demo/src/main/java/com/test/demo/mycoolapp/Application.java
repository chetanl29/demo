package com.test.demo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		/*1. SpringApplication class starts an Embedded server Tomcat etc..., 
		 *2. Creates ApplicationContext and registers all beans
		 *3. Bootstraps your Spring Boot Application
		 *4. Always place your main Application class in root package above your other packages*/
	}

}
