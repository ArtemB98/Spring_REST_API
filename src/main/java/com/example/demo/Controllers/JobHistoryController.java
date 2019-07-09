package com.example.demo.Controllers;


import com.example.demo.Entities.JobHistory;
import com.example.demo.Services.JobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobhistory")
public class JobHistoryController {
    @Autowired
    private JobHistoryService JobHistoryService;

    @RequestMapping(value = "/update", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<JobHistory> updhist(@RequestBody JobHistory histload) throws Exception {
        return new ResponseEntity<JobHistory>(JobHistoryService.updateJobHistory(histload), HttpStatus.OK);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<JobHistory> postehist(@RequestBody JobHistory histload) throws Exception {
        return new ResponseEntity<JobHistory>(JobHistoryService.addJobHistory(histload), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    public void deletehist(@PathVariable final Long id) throws Exception {
        if (JobHistoryService.findJobHistory(id) == null) {//???
            throw new Exception("Employee to delete doesn´t exist");
        }
        JobHistoryService.deleteJobHistory(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    //  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<JobHistory> findByid(@PathVariable final Long id) throws Exception {
        List<JobHistory> e = JobHistoryService.findJobHistory(id);
        if (e == null) {
            throw new Exception("Employee with this ID doesn´t exist");
        }
        return e;
    }
}
