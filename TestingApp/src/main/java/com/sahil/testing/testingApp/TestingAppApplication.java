package com.sahil.testing.testingApp;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class TestingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingAppApplication.class, args);
	}

}
