package com.springBootWebTutorial.springBootWebTutorialApplication.controllers;

import com.springBootWebTutorial.springBootWebTutorialApplication.dto.EmployeeDTO;
import com.springBootWebTutorial.springBootWebTutorialApplication.entities.EmployeeEntity;
import com.springBootWebTutorial.springBootWebTutorialApplication.services.EmployeeService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "/employees") // parent path
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Secret Message: asdfgh@#$%DSANB";
//    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
        public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                                    @RequestParam(required = false) String sortBy){
        return employeeService.getAllEmployees();
    }

    // for creating new resources
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

//    to update existing resource
    @PutMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return employeeService.updateEmployeeById(employeeDTO, employeeId);
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteById(@PathVariable Long employeeId){
       return employeeService.deleteById(employeeId) ;
    }
}
