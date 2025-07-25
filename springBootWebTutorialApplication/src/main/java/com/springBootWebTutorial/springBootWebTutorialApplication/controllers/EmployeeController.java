package com.springBootWebTutorial.springBootWebTutorialApplication.controllers;

import com.springBootWebTutorial.springBootWebTutorialApplication.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees") // parent path
public class EmployeeController {

    @GetMapping(path = "/getSecretMessage")
    public String getMySuperSecretMessage(){
        return "Secret Message: asdfgh@#$%DSANB";
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return new EmployeeDTO(id,"Sahil Patel", "sahil@gmail.com",21, LocalDate.of(2025,7,24),true);
    }

    @GetMapping
        public String getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                      @RequestParam(required = false) String sortBy){
        return "Hi age " + age + " " +sortBy;
    }

    // for creating new resources
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(100L);
        return inputEmployee;
    }

    // Updating (replacing) an existing resource entirely.
    @PutMapping
    public String updateEmployeeById(){
        return "Hello from PUT";
    }

    // Updating some fields of an existing resource.
    @PatchMapping
    public String patch(){
        return "Hello from PATCH" ;
    }

    // Deleting a resource.
    @DeleteMapping
    public String deleteEmployee(){
        return  "Hello from DELETE";
    }
}
