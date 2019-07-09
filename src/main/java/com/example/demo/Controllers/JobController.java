package com.example.demo.Controllers;


import com.example.demo.Entities.Job;
import com.example.demo.Services.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobsService JobsService;

    @RequestMapping(value = "/update", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<Job> updjob(@RequestBody Job jobload) throws Exception {
        return new ResponseEntity<Job>(JobsService.updateJob(jobload), HttpStatus.OK);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<Job> posteemp(@RequestBody Job jobload) throws Exception {
        return new ResponseEntity<Job>(JobsService.addJob(jobload), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    public void deleteJob(@PathVariable final String id) throws Exception {
        if (JobsService.findJob(id) == null) {//удалить историю работы
            throw new Exception("Job to delete doesn´t exist");
        }
        JobsService.deleteJob(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Job findByid(@PathVariable final String id) throws Exception {
        Job e = JobsService.findJob(id);
        if (e == null) {
            throw new Exception("Job with this ID doesn´t exist");
        }
        return e;
    }
}
