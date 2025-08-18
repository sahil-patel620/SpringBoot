package com.week3.collegeManagementSystem.controllers;

import com.week3.collegeManagementSystem.dtos.StudentRequestDTO;
import com.week3.collegeManagementSystem.dtos.StudentResponseDTO;
import com.week3.collegeManagementSystem.services.CollegeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/college")
@RequiredArgsConstructor
public class CollegeControllers {
    private  final CollegeServices collegeServices;

    @GetMapping({"/studentId"})
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long studentId){
        Optional<StudentResponseDTO> studentResponseDTO = collegeServices.getStudentById(studentId);
        return studentResponseDTO
                .map(studentResponseDTO1 -> ResponseEntity.ok(studentResponseDTO1))
                .orElseThrow();
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        StudentResponseDTO response = collegeServices.createStudent(studentRequestDTO);
       return new  ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(){
        return ResponseEntity.ok(collegeServices.getAllStudents());
    }

    @DeleteMapping(path = "/{studentId}")
    public ResponseEntity<Boolean> deleteStudentById(@PathVariable Long studentId){
        boolean gotDeleted = collegeServices.deleteStudentById(studentId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
}
