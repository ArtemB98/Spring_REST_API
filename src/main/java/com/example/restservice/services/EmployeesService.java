package com.example.restservice.services;

import com.example.restservice.entities.Employee;
import com.example.restservice.entityDTOs.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class EmployeesService {
    @Autowired
    private com.example.restservice.services.repositories.EmployeesRepository EmployeesRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Employee findEmp(Long id) {
        return EmployeesRepository.findByEmployeeId(id);
    }

    public EmployeeDTO addEmployee(Employee Employee) {
        return EntityToDTO(EmployeesRepository.saveAndFlush(Employee));
    }

    public void deleteEmployee(long id) {
        EmployeesRepository.deleteById(id);
    }

    public EmployeeDTO updateEmployees(Employee Employee) {
        return EntityToDTO(EmployeesRepository.saveAndFlush(Employee));
    }

    public List<String> getSQL1() {
        return EmployeesRepository.getLastNamesWithColleaguesWithHigherSalaryAndEarlierHireDate();
    }

    public List<EmployeeDTO> getSQL2() {
        List<Employee> l = EmployeesRepository.getHighPayedEmployees();
        List<EmployeeDTO> l1 = new ArrayList<EmployeeDTO>();
        for (int i = 0; i < l.size(); i++)
            l1.add(EntityToDTO(l.get(i)));
        return l1;
    }

    public EmployeeDTO EntityToDTO(Employee c) {
        return modelMapper.map(c, EmployeeDTO.class);
    }

    public Employee EmployeeDTOToEntity(EmployeeDTO c) {
        return modelMapper.map(c, Employee.class);
    }
}
