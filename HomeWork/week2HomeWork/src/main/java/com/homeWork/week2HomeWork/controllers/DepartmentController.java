package com.homeWork.week2HomeWork.controllers;

import com.homeWork.week2HomeWork.Exception.ResourceNotFoundException;
import com.homeWork.week2HomeWork.dto.DepartmentDTO;
import com.homeWork.week2HomeWork.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
 private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        return  ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable(name = "departmentId") Long id){
        Optional<DepartmentDTO> departmentDTO = departmentService.getDepartmentById(id);
        return departmentDTO.map(departmentDTO1-> ResponseEntity.ok(departmentDTO1))
                .orElseThrow(()-> new ResourceNotFoundException("Department not found with id: "+id));
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO inputDepartment){
        DepartmentDTO savedDepartment = departmentService.createNewDepartment(inputDepartment);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentDTO, departmentId));
    }

    @DeleteMapping(path ="/{departmentId}" )
    public ResponseEntity<String> deleteById(@PathVariable Long departmentId){
        boolean gotDeleted = departmentService.deleteById(departmentId);
        if(gotDeleted) return ResponseEntity.ok("Successfully Deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }

    @PatchMapping(path ="/{departmentId}" )
    public ResponseEntity<DepartmentDTO> updatePartiallyById(@RequestBody Map<String, Object> updates, @PathVariable Long departmentId){
        DepartmentDTO departmentDTO = departmentService.updatePartiallyById(departmentId, updates);
        if (departmentDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentDTO);
    }
}
