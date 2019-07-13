package com.example.restservice.controllers;

import com.example.restservice.entities.Job;
import com.example.restservice.entityDTOs.JobDTO;
import com.example.restservice.services.JobsService;
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
    public ResponseEntity<JobDTO> updjob(@RequestBody JobDTO jobload) throws Exception {
        return new ResponseEntity<JobDTO>(JobsService.updateJob(JobsService.JobDTOToEntity(jobload)), HttpStatus.OK);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<JobDTO> posteemp(@RequestBody JobDTO jobload) throws Exception {
        return new ResponseEntity<JobDTO>(JobsService.addJob(JobsService.JobDTOToEntity(jobload)), HttpStatus.OK);
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
    public JobDTO findByid(@PathVariable final String id) throws Exception {
        Job e = JobsService.findJob(id);
        if (e == null) {
            throw new Exception("Job with this ID doesn´t exist");
        }
        return JobsService.EntityToDTO(e);
    }
}
