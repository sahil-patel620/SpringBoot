package com.week3.collegeManagementSystem.services;

import com.week3.collegeManagementSystem.dtos.StudentRequestDTO;
import com.week3.collegeManagementSystem.dtos.StudentResponseDTO;
import com.week3.collegeManagementSystem.repositories.AdmissionRecordRepository;
import com.week3.collegeManagementSystem.repositories.ProfessorRepository;
import com.week3.collegeManagementSystem.repositories.StudentRepository;
import com.week3.collegeManagementSystem.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CollegeServices {

    private final AdmissionRecordRepository admissionRecordRepository;
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    private final ModelMapper modelMapper;
//
//    public Optional<StudentResponseDTO> getStudentById(Long id ){
////        Student student = studentRepository.findById(id).orElseThrow();
////        return modelMapper.map(student, StudentResponseDTO.class);
//
//        return studentRepository.findById(id)
//                .map(student -> modelMapper.map(student, StudentResponseDTO.class));
//    }
//
//    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO){
//        StudentEntity studentEntity = modelMapper.map(studentRequestDTO, StudentEntity.class);
//        StudentEntity savedStudentEntity = studentRepository.save(studentEntity);
//        return modelMapper.map(savedStudentEntity, StudentResponseDTO.class);
//    }
//
//    public List<StudentResponseDTO> getAllStudents(){
//        return studentRepository.findAll()
//                .stream()
//                .map(student -> modelMapper.map(student, StudentResponseDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    public boolean deleteStudentById(Long studentId) {
//        studentRepository.findById(studentId)
//                .orElseThrow(()-> new RuntimeException("Employee Not found with id: "+ studentId));
//        studentRepository.deleteById(studentId);
//        return true;
//    }
}
