package com.week3.collegeManagementSystem.services;

import com.week3.collegeManagementSystem.dtos.ProfessorDTO;
import com.week3.collegeManagementSystem.dtos.StudentDTO;
import com.week3.collegeManagementSystem.dtos.SubjectDTO;
import com.week3.collegeManagementSystem.entities.ProfessorEntity;
import com.week3.collegeManagementSystem.entities.StudentEntity;
import com.week3.collegeManagementSystem.entities.SubjectEntity;
import com.week3.collegeManagementSystem.exceptions.ResourceNotFoundException;
import com.week3.collegeManagementSystem.repositories.ProfessorRepository;
import com.week3.collegeManagementSystem.repositories.StudentRepository;
import com.week3.collegeManagementSystem.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    private void  isExistsByIdStudent(Long id){
        boolean isExist = studentRepository.existsById(id);
        if(!isExist) throw new ResourceNotFoundException("Student does not found by id: "+ id);
    }

    public List<StudentDTO> getAllStudents() {
        return  studentRepository.findAll()
                .stream()
                .map(studentEntity -> modelMapper.map(studentEntity, StudentDTO.class))
                .collect(Collectors.toList());
    }


    public StudentDTO getStudentById(Long studentId) {
        isExistsByIdStudent(studentId);
        return modelMapper.map(studentRepository.findById(studentId).get(), StudentDTO.class);
    }

    public  StudentDTO updateStudentById(Long studentId, StudentDTO studentDTO){
        isExistsByIdStudent(studentId);
        studentDTO.setId(studentId);
        return  modelMapper.map(studentRepository.save(modelMapper.map(studentDTO,StudentEntity.class)),StudentDTO.class);
    }

    public void deleteStudentById(Long studentId) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found by id:"+studentId));
        // Remove the student from all professors' sets
        for (ProfessorEntity professorEntity : studentEntity.getProfessors()) {
            professorEntity.getStudents().remove(studentEntity);
            professorRepository.save(professorEntity);
        }
        // Remove the student from all subject's sets
        for (SubjectEntity subjectEntity : studentEntity.getSubjects()) {
            subjectEntity.getStudents().remove(studentEntity);
            subjectRepository.save(subjectEntity);
        }
        studentRepository.deleteById(studentId);
    }

    public StudentDTO createStudent(StudentDTO studentDto) {
        return modelMapper.map(studentRepository.save(modelMapper.map(studentDto, StudentEntity.class)),StudentDTO.class);
    }

    public List<ProfessorDTO> getAssignedProfessorsToStudent(Long studentId) {
        isExistsByIdStudent(studentId);
        List<ProfessorEntity> professorEntities = studentRepository.findById(studentId).get().getProfessors().stream().toList();
        return professorEntities.stream().map(professorEntity -> modelMapper.map(professorEntity,ProfessorDTO.class)).collect(Collectors.toList());
    }

    public List<SubjectDTO> getAssignedSubjectsToStudent(Long studentId) {
        isExistsByIdStudent(studentId);
        List<SubjectEntity> subjectEntities = studentRepository.findById(studentId).get().getSubjects().stream().toList();
        return subjectEntities.stream().map(subjectEntity -> modelMapper.map(subjectEntity,SubjectDTO.class)).collect(Collectors.toList());
    }

}
