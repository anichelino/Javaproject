package com.example.com.firstspringtraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(proxyBeanMethods = false)
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext runApplicationContext = SpringApplication.run(Application.class, args);

	}

}
