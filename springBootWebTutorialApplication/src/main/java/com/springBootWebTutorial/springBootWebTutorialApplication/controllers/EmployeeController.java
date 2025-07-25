package com.springBootWebTutorial.springBootWebTutorialApplication.controllers;

import com.springBootWebTutorial.springBootWebTutorialApplication.dto.EmployeeDTO;
import com.springBootWebTutorial.springBootWebTutorialApplication.entities.EmployeeEntity;
import com.springBootWebTutorial.springBootWebTutorialApplication.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees") // parent path
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/getSecretMessage")
    public String getMySuperSecretMessage(){
        return "Secret Message: asdfgh@#$%DSANB";
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
        public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                                    @RequestParam(required = false) String sortBy){
        return  employeeRepository.findAll();
    }

    // for creating new resources
    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);
    }

    // Updating (replacing) an existing resource entirely.
    @PutMapping
    public String updateEmployeeById(){
        return "Hello from PUT";
    }

    // Updating some fields of an existing resource.
    @PatchMapping
    public String patch(){
        return "Hello from PATCH";
    }

    // Deleting a resource.
    @DeleteMapping
    public String deleteEmployee(){
        return  "Hello from DELETE";
    }
}
