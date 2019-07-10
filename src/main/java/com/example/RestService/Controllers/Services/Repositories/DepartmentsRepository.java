package com.example.RestService.Controllers.Services.Repositories;

import com.example.RestService.Controllers.Services.Repositories.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentId(Long id);
}
