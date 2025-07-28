package com.springBootWebTutorial.springBootWebTutorialApplication.services;

import com.springBootWebTutorial.springBootWebTutorialApplication.dto.EmployeeDTO;
import com.springBootWebTutorial.springBootWebTutorialApplication.entities.EmployeeEntity;
import com.springBootWebTutorial.springBootWebTutorialApplication.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id){
//        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
//        return modelMapper.map(employeeEntity,EmployeeDTO.class); // ModelMapper.map will convert employeeEntity into EmployeeDTO
        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
    }

    public List<EmployeeDTO>getAllEmployees(){

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeEntity inputEmployee){
//      to check if user is admin
//      log something
       EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee,EmployeeEntity.class);
       EmployeeEntity savedEmployeeEntity =  employeeRepository.save(toSaveEntity);
       return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);

    }

//  this function will update existing resource if not available then add new one with the data
    public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Long employeeId) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public boolean isExistsInRepository(Long employeeId){
        return employeeRepository.existsById(employeeId);
    }

//  this function will delete the data using employeeId (if exists)
    public boolean deleteById(Long employeeId) {
        boolean exists = isExistsInRepository(employeeId);
        if (exists){
            employeeRepository.deleteById(employeeId);
            return  true;
        }else {
            return false;
        }
    }

    public EmployeeDTO updatePartiallyById(Long employeeId, Map<String, Object> updates) {
        boolean exists = isExistsInRepository(employeeId);
        if (!exists) return null;
        EmployeeEntity  employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field, value) ->{
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
    }
}
