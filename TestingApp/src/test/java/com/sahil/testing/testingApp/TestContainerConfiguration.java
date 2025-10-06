package com.sahil.testing.testingApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@Configuration
public class TestContainerConfiguration {

//    Chatgpt solution
    @Bean
    PostgreSQLContainer<?> postgresContainer() {
        PostgreSQLContainer<?> container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
                .withDatabaseName("testdb")
                .withUsername("user")
                .withPassword("password")
                .withEnv("TZ", "Asia/Kolkata"); // set proper timezone

        // Start container immediately so Spring Boot can use it
        container.start();

        // Override Spring datasource properties for tests
        System.setProperty("spring.datasource.url", container.getJdbcUrl());
        System.setProperty("spring.datasource.username", container.getUsername());
        System.setProperty("spring.datasource.password", container.getPassword());

        return container;
    }



//    My solution
//    @Bean
////    @ServiceConnection
//    PostgreSQLContainer<?> postgresContainer(){
//        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
//    }

}

