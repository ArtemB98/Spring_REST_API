package com.example.demo.Services;

import com.example.demo.Entities.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.DepartmentsRepository;

@Service
public class DepartmentsService {
    @Autowired
    private DepartmentsRepository DepartmentsRepository;

    public Departments findDepartment(Long id) {
        return DepartmentsRepository.findByid(id);
    }

    public Departments addDepartment(Departments Department) {
        return DepartmentsRepository.saveAndFlush(Department);
    }

    public void deleteDepartment(Long id) {
        DepartmentsRepository.deleteById(id);
    }

    public Departments updateDepartment(Departments Department) {
        return DepartmentsRepository.saveAndFlush(Department);
    }
}
