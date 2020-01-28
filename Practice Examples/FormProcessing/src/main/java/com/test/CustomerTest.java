package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(scanBasePackages= {"com.test.config"})
@EnableWebSecurity
public class CustomerTest {

	public static void main(String[] args) {
		SpringApplication.run(CustomerTest.class, args);
	}

}
