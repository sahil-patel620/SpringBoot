package com.week3.collegeManagementSystem.controllers;

import com.week3.collegeManagementSystem.dtos.ProfessorDTO;
import com.week3.collegeManagementSystem.dtos.StudentDTO;
import com.week3.collegeManagementSystem.dtos.SubjectDTO;
import com.week3.collegeManagementSystem.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long studentId){
        return   ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDTO> updateStudentById(@PathVariable Long studentId, @RequestBody StudentDTO studentDto) {
        return ResponseEntity.ok(studentService.updateStudentById(studentId,studentDto));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDto) {
        return ResponseEntity.ok(studentService.createStudent(studentDto));
    }

    @GetMapping("/{studentId}/assignedProfessors")
    public ResponseEntity<List<ProfessorDTO>> getAssignedProfessorsToStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.getAssignedProfessorsToStudent(studentId));
    }

    @GetMapping("/{studentId}/assignedSubjects")
    public ResponseEntity<List<SubjectDTO>> getAssignedSubjectsToStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.getAssignedSubjectsToStudent(studentId));
    }

}
