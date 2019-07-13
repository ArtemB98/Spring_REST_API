package com.example.restservice.services.repositories;

import com.example.restservice.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentId(Long id);
}
