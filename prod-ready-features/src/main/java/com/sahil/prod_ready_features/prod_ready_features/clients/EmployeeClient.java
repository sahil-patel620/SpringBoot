package com.sahil.prod_ready_features.prod_ready_features.clients;

import com.sahil.prod_ready_features.prod_ready_features.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
