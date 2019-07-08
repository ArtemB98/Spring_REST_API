package com.example.demo.Controllers;


import com.example.demo.Entities.Jobs;
import com.example.demo.Services.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobsService JobsService;

    @RequestMapping(value = "/update", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE},headers = "Accept=application/json")
    public ResponseEntity<Jobs> updjob(@RequestBody Jobs jobload) throws Exception{
        return new ResponseEntity<Jobs>(JobsService.updateJob(jobload), HttpStatus.OK);
    }
    @RequestMapping(value = "/post", method = RequestMethod.POST,  produces = {MediaType.APPLICATION_JSON_VALUE},headers = "Accept=application/json")
    public ResponseEntity<Jobs> posteemp(@RequestBody Jobs jobload) throws Exception{
        return new ResponseEntity<Jobs>(JobsService.addJob(jobload), HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,  produces = {MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
    public void deleteJob(@PathVariable final String id) throws Exception{
        if (JobsService.findJob(id) == null){//удалить историю работы
            throw new Exception("Jobs to delete doesn´t exist");
        }
        JobsService.deleteJob(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET,  produces = {MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Jobs findByid(@PathVariable final String id)  throws Exception{
        Jobs e = JobsService.findJob(id);
        if (e == null){
            throw new Exception("Job with this ID doesn´t exist");
        }
        return e;
    }
}
