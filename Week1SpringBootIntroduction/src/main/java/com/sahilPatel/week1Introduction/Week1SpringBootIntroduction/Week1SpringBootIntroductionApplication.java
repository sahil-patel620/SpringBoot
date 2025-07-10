package com.sahilPatel.week1Introduction.Week1SpringBootIntroduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week1SpringBootIntroductionApplication implements CommandLineRunner {

//	@Autowired
//	Apple apple1;
//	@Autowired
//	Apple apple2;

	@Autowired   // field dependency injection
	DBservice dbservice;
	public static void main(String[] args) {
		SpringApplication.run(Week1SpringBootIntroductionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(dbservice.getData());
//		apple1.eatApple();
//		apple2.eatApple();
//		System.out.println(apple1.hashCode());
//		System.out.println(apple2.hashCode());

	}
}
