package com.example.restservice.services;

import com.example.restservice.entities.Department;
import com.example.restservice.entityDTOs.DepartmentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentsService {
    @Autowired
    private com.example.restservice.services.repositories.DepartmentsRepository DepartmentsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Department findDepartment(Long id) {
        return DepartmentsRepository.findByDepartmentId(id);
    }

    public DepartmentDTO addDepartment(Department Department) {
        return EntityToDTO(DepartmentsRepository.saveAndFlush(Department));
    }

    public void deleteDepartment(Long id) {
        DepartmentsRepository.deleteById(id);
    }

    public DepartmentDTO updateDepartment(Department Department) {
        return EntityToDTO(DepartmentsRepository.saveAndFlush(Department));
    }

    public DepartmentDTO EntityToDTO(Department c) {
        return modelMapper.map(c, DepartmentDTO.class);
    }

    public Department DepartmentDTOToEntity(DepartmentDTO c) {
        return modelMapper.map(c, Department.class);
    }
}
