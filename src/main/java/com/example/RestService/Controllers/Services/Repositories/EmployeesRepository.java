package com.example.RestService.Controllers.Services.Repositories;

import com.example.RestService.Controllers.Services.Repositories.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeId(Long id);

    @Query("select e1.lastName from Employee e1 where e1.department_id in (select e2.department_id from Employee e2 where e1.employeeId <> e2.employeeId and e1.department_id = e2.department_id and e1.salary < e2.salary and e1.hireDate < e2.hireDate)")
    List<String> getLastNamesWithColleaguesWithHigherSalaryAndEarlierHireDate();

    @Query("select e1 from Employee e1 where e1.salary >(select avg(e2.salary) from Employee e2 where e1.department_id = e2.department_id) order by e1.salary")
    List<Employee> getHighPayedEmployees();
}