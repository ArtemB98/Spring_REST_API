package com.example.demo.repository;

import com.example.demo.Entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    @Query("select b from Employees b where b.employeeId = :id")
    Employees findByid(@Param("id") Long id);

    @Query("select e1.lastName from Employees e1 where e1.department_id in (select e2.department_id from Employees e2 where e1.employeeId <> e2.employeeId and e1.department_id = e2.department_id and e1.salary < e2.salary and e1.hireDate < e2.hireDate)")
    List<String> getLastNamesWithColleaguesWithHigherSalaryAndEarlierHireDate();

    @Query("select e1 from Employees e1 where e1.salary >(select avg(e2.salary) from Employees e2 where e1.department_id = e2.department_id) order by e1.salary")
    List<Employees> getHighPayedEmployees();
}