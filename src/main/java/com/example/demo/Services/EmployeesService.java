package com.example.demo.Services;

import com.example.demo.Entities.Employee;
import com.example.demo.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class EmployeesService {
    @Autowired
    private EmployeesRepository EmployeesRepository;

    public Employee findEmp(Long id) {
        return EmployeesRepository.findByEmployeeId(id);
    }

    public Employee addEmployee(Employee Employee) {
        return EmployeesRepository.saveAndFlush(Employee);
    }

    public void deleteEmployee(long id) {
        EmployeesRepository.deleteById(id);
    }

    public Employee updateEmployees(Employee Employee) {
        return EmployeesRepository.saveAndFlush(Employee);
    }

    public List<String> getSQL1() {
        return EmployeesRepository.getLastNamesWithColleaguesWithHigherSalaryAndEarlierHireDate();
    }

    public List<Employee> getSQL2() {
        return EmployeesRepository.getHighPayedEmployees();
    }
}
