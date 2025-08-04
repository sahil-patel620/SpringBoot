package com.homeWork.week2HomeWork.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeWork.week2HomeWork.Exception.ResourceNotFoundException;
import com.homeWork.week2HomeWork.dto.DepartmentDTO;
import com.homeWork.week2HomeWork.entities.DepartmentEntity;
import com.homeWork.week2HomeWork.repositories.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;


    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<DepartmentDTO> getDepartmentById(Long id) {
//        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElse(null);
//        return modelMapper.map(departmentEntity,DepartmentDTO.class);
        return departmentRepository.findById(id).map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class));
    }


    public DepartmentDTO createNewDepartment(DepartmentDTO inputDepartment) {
        DepartmentEntity toSaveEntity = modelMapper.map(inputDepartment, DepartmentEntity.class);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(DepartmentDTO departmentDTO, Long departmentId) {
        isExistsInRepository(departmentId);
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }


    public boolean deleteById(Long departmentId) {
        isExistsInRepository(departmentId);
        if (departmentRepository.existsById(departmentId)) {
            departmentRepository.deleteById(departmentId);
            return true;
        } else {
            return false;
        }
    }

    public DepartmentDTO updatePartiallyById(Long departmentId, Map<String, Object> updates) {
        isExistsInRepository(departmentId);
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(DepartmentEntity.class, field);
                fieldToBeUpdated.setAccessible(true);

            Object convertedValue = value;

            // Manually handle LocalDate conversion
            if (fieldToBeUpdated.getType().equals(LocalDate.class) && value instanceof String) {
                convertedValue = LocalDate.parse((String) value);
            }
                ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, convertedValue);
        });
        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);
    }


    public void isExistsInRepository(Long departmentId){
        boolean exists = departmentRepository.existsById(departmentId);
        if (!exists) throw new ResourceNotFoundException("Resource not found with id: "+departmentId);
    }

}
