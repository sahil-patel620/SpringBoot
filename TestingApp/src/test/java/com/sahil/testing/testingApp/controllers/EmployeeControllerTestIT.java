package com.sahil.testing.testingApp.controllers;

import com.sahil.testing.testingApp.TestContainerConfiguration;
import com.sahil.testing.testingApp.dto.EmployeeDto;
import com.sahil.testing.testingApp.entities.Employee;
import com.sahil.testing.testingApp.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureWebTestClient(timeout = "100000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestContainerConfiguration.class)
class EmployeeControllerTestIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee testEmployee;
    private EmployeeDto testEmployeeDto;

    @BeforeEach
    void setUp(){

        String uniqueEmail = "sahil+" + System.currentTimeMillis() + "@gmail.com";
        testEmployee = Employee.builder()
//                .id(1L)   don't add manually otherwise you will get ObjectOptimisticLockingFailureException
                .name("Sahil")
                .email(uniqueEmail)
                .salary(200L)
                .build();

        testEmployeeDto = EmployeeDto.builder()
//                .id(1L)
                .name("Sahil")
                .email(uniqueEmail)
                .salary(200L)
                .build();
        employeeRepository.deleteAll();
    }

    @Test
    void testGetEmployeeById_success(){
       Employee savedEmployee = employeeRepository.save(testEmployee);
        // update DTO with generated ID for comparison
        testEmployeeDto.setId(savedEmployee.getId());
       webTestClient.get()
               .uri("/employees/{id}",savedEmployee.getId())
               .exchange()
               .expectStatus().isOk()
               .expectBody(EmployeeDto.class)
               .isEqualTo(testEmployeeDto);   // use only when hashcode and equals are added in EmployeeDto
//               .value(employeeDto -> {
//                   assertThat(employeeDto.getEmail()).isEqualTo(savedEmployee.getEmail());
//                   assertThat(employeeDto.getId()).isEqualTo(savedEmployee.getId());
//               });
    }

    @Test
    void testGetEmployeeById_Failure(){
        webTestClient.get()
                .uri("/employees/1")
                .exchange()
                .expectStatus().isNotFound( );
    }

    @Test
    void testCreateNewEmployee_whenEmployeeAlreadyExists_thenThrowException(){
        Employee savedEmployee = employeeRepository.save(testEmployee);

    }
}