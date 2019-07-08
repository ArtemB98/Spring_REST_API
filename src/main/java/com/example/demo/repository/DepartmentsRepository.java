package com.example.demo.repository;
import com.example.demo.Entities.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
    @Query("select b from Departments b where b.departmentId = :id")
    Departments findByid(@Param("id") Long id);
}
