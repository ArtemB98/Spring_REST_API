package com.example.demo.Services;

import com.example.demo.Entities.Employees;
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

    public Employees findEmp(Long id) {
        return EmployeesRepository.findByEmployeeId(id);
    }

    public Employees addEmployee(Employees Employee) {
        return EmployeesRepository.saveAndFlush(Employee);
    }

    public void deleteEmployee(long id) {
        EmployeesRepository.deleteById(id);
    }

    public Employees updateEmployees(Employees Employee) {
        return EmployeesRepository.saveAndFlush(Employee);
    }

    public List<String> getSQL1() {
        return EmployeesRepository.getLastNamesWithColleaguesWithHigherSalaryAndEarlierHireDate();
    }

    public List<Employees> getSQL2() {
        return EmployeesRepository.getHighPayedEmployees();
    }
}
