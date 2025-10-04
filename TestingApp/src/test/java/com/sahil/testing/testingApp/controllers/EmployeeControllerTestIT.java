package com.sahil.testing.testingApp.controllers;

import com.sahil.testing.testingApp.TestContainerConfiguration;
import com.sahil.testing.testingApp.dto.EmployeeDto;
import com.sahil.testing.testingApp.entities.Employee;
import com.sahil.testing.testingApp.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class EmployeeControllerTestIT extends AbstractIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee testEmployee;
    private EmployeeDto testEmployeeDto;

    @BeforeEach
    void setUp(){

        String uniqueEmail = "sahil" + System.currentTimeMillis() + "@gmail.com";
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
               .expectBody()
                .jsonPath("$.id").isEqualTo(savedEmployee.getId())
                .jsonPath("$.email").isEqualTo(savedEmployee.getEmail());
//               .isEqualTo(testEmployeeDto);   // use only when hashcode and equals are added in EmployeeDto
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
                .expectStatus().isNotFound();
    }

    @Test
    void testCreateNewEmployee_whenEmployeeAlreadyExists_thenThrowException(){
        Employee savedEmployee = employeeRepository.save(testEmployee);
        webTestClient.post()
                .uri("/employees")
                .bodyValue(testEmployeeDto)
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void testCreateNewEmployee_whenEmployeeDoesNotExists_theCreateEmployee(){
        webTestClient.post()
                .uri("/employees")
                .bodyValue(testEmployeeDto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.email").isEqualTo(testEmployeeDto.getEmail())
                .jsonPath("$.name").isEqualTo(testEmployeeDto.getName());
    }

    @Test
    void testUpdateEmployee_whenEmployeeDoesNotExists_thenThrowException(){
        webTestClient.put()
                .uri("employees/999")
                .bodyValue(testEmployeeDto)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdateEmployee_whenAttemptingToUpdateTheEmail_thenThrowException(){
        Employee savedEmployee = employeeRepository.save(testEmployee);
        testEmployeeDto.setId(savedEmployee.getId());
        testEmployeeDto.setName("Random");
        testEmployeeDto.setEmail("Random@gmail.com");

        webTestClient.put()
                .uri("/employees/{id}",savedEmployee.getId())
                .bodyValue(testEmployeeDto)
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void testUpdateEmployee_whenEmployeeIsValid_thenUpdateEmployee(){
        Employee savedEmployee = employeeRepository.save(testEmployee);
        testEmployeeDto.setId(savedEmployee.getId());
        testEmployeeDto.setName("Random Name");
        testEmployeeDto.setSalary(300L);

        webTestClient.put()
                .uri("/employees/{id}",savedEmployee.getId())
                .bodyValue(testEmployeeDto)
                .exchange()
                .expectStatus().isOk()
                .expectBody(EmployeeDto.class).isEqualTo(testEmployeeDto);
    }

    @Test
    void testDeleteEmployee_whenEmployeeDoesNotExists_thenThrowException(){

        webTestClient.delete()
                .uri("/employees/1")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void  testDeleteEmployee_whenEmployeeExists_thenDeleteEmployee(){
        Employee savedEmployee = employeeRepository.save(testEmployee);

        webTestClient.delete()
                .uri("/employees/{id}",savedEmployee.getId())
                .exchange()
                .expectStatus().isNoContent()
                .expectBody(Void.class);

//        Double-checking for deletion
        webTestClient.delete()
                .uri("/employees/{id}",savedEmployee.getId())
                .exchange()
                .expectStatus().isNotFound();
    }
}