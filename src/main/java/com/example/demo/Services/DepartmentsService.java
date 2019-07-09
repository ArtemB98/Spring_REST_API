package com.example.demo.Services;

import com.example.demo.Entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.DepartmentsRepository;

@Service
public class DepartmentsService {
    @Autowired
    private DepartmentsRepository DepartmentsRepository;

    public Department findDepartment(Long id) {
        return DepartmentsRepository.findByDepartmentId(id);
    }

    public Department addDepartment(Department Department) {
        return DepartmentsRepository.saveAndFlush(Department);
    }

    public void deleteDepartment(Long id) {
        DepartmentsRepository.deleteById(id);
    }

    public Department updateDepartment(Department Department) {
        return DepartmentsRepository.saveAndFlush(Department);
    }
}
