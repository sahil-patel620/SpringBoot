package com.sahil.prod_ready_features.prod_ready_features;

import com.sahil.prod_ready_features.prod_ready_features.clients.EmployeeClient;
import com.sahil.prod_ready_features.prod_ready_features.dtos.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProdReadyFeaturesApplicationTests {

    @Autowired
    private EmployeeClient employeeClient;

	@Test
    @Order(3)
	void getAllEmployeesTest(){
        List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
        System.out.println(employeeDTOList);
    }

    @Test
    @Order(2)
    void  getEmployeeByIdTest(){
        EmployeeDTO employeeDTO = employeeClient.getEmployeeById(3L);
        System.out.println(employeeDTO);
    }

    @Test
    @Order(1)
    void createNewEmployee(){
        EmployeeDTO employeeDTO = new EmployeeDTO(null,"Sahil","sahil@gmail.com",2,
                LocalDate.of(2025,8,15),"USER", 10005.0,true,5);
        EmployeeDTO savedEmployeeDTO = employeeClient.createNewEmployee(employeeDTO);
        System.out.println(savedEmployeeDTO);
    }
}
