package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import com.example.demo.Services.EmployeesService;
import com.example.demo.repository.EmployeesRepository;
import com.example.demo.Entities.Employee;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @MockBean
    private EmployeesRepository empRep;

    @Autowired
    private EmployeesService empServ;

    @Test
    public void SaveEmp() {
        Employee emp = new Employee();
        emp.setEmployeeId(210L);
        emp.setFirstName("Artem");
        emp.setLastName("Berdnikov");
        emp.setEmail("artem.ru");
        emp.setHireDate(new Date(10, 11, 12));
        emp.setJob_id("AD_VP");
        emp.setDepartment_id(90L);
        emp.setManager_id(100L);
        when(empRep.saveAndFlush(emp)).thenReturn(emp);
        assertEquals(emp, empServ.addEmployee(emp));
    }
}
