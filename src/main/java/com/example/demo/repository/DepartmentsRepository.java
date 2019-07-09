package com.example.demo.repository;

import com.example.demo.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentId(Long id);
}
