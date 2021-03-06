package com.example.restservice.controllers;

import com.example.restservice.entities.Employee;
import com.example.restservice.entityDTOs.EmployeeDTO;
import com.example.restservice.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeesService employeeService;

    @RequestMapping(value = "/update", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<EmployeeDTO> updeemp(@RequestBody EmployeeDTO empload) throws Exception {
        return new ResponseEntity<EmployeeDTO>(employeeService.updateEmployees(employeeService.EmployeeDTOToEntity(empload)), HttpStatus.OK);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<EmployeeDTO> posteemp(@RequestBody EmployeeDTO empload) throws Exception {
        return new ResponseEntity<EmployeeDTO>(employeeService.addEmployee(employeeService.EmployeeDTOToEntity(empload)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    public void deleteemp(@PathVariable final Long id) throws Exception {
        if (employeeService.findEmp(id) == null) {//удалить историю работы
            throw new Exception("Employee to delete doesn´t exist");
        }
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EmployeeDTO findByid(@PathVariable final Long id) throws Exception {
        Employee e = employeeService.findEmp(id);
        if (e == null) {
            throw new Exception("Employee with this ID doesn´t exist");
        }
        return employeeService.EntityToDTO(e);
    }

    @RequestMapping(value = "/getLastNamesWithColleaguesWithHigherSalaryAndEarlierHireDate", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    public List<String> runsql1() {
        return employeeService.getSQL1();
    }

    @RequestMapping(value = "/getHighPayedEmployees", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    public List<EmployeeDTO> runsql2() {
        return employeeService.getSQL2();
    }
}