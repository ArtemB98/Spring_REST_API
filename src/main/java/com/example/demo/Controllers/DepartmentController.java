package com.example.demo.Controllers;


import com.example.demo.Entities.Department;
import com.example.demo.Services.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentsService DepartmentService;

    @RequestMapping(value = "/update", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<Department> upddep(@RequestBody Department depload) throws Exception {
        return new ResponseEntity<Department>(DepartmentService.updateDepartment(depload), HttpStatus.OK);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<Department> postdep(@RequestBody Department depload) throws Exception {
        return new ResponseEntity<Department>(DepartmentService.addDepartment(depload), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    public void deletdep(@PathVariable final Long id) throws Exception {
        if (DepartmentService.findDepartment(id) == null) {//удалить сотрудников
            throw new Exception("Department to delete doesn´t exist");
        }
        DepartmentService.deleteDepartment(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Department findByid(@PathVariable final Long id) throws Exception {
        Department e = DepartmentService.findDepartment(id);
        if (e == null) {
            throw new Exception("Department with this ID doesn´t exist");
        }
        return e;
    }
}
