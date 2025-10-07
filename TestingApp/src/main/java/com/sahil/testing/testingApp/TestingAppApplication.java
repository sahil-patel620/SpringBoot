package com.sahil.testing.testingApp;

import com.sahil.testing.testingApp.services.DataService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;
@RequiredArgsConstructor
@SpringBootApplication
public class TestingAppApplication implements CommandLineRunner {

    private final DataService dataService;

    @Value("${my.Variable}")
    private String myVariable;

	public static void main(String[] args) {
		SpringApplication.run(TestingAppApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        System.out.println("my variable: "+ myVariable);
        System.out.println("The data is: "+ dataService.getData());
    }
}
