package com.example.restservice.controllers;

import com.example.restservice.entities.JobHistory;
import com.example.restservice.entityDTOs.JobHistoryDTO;
import com.example.restservice.services.JobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobhistory")
public class JobHistoryController {
    @Autowired
    private JobHistoryService JobHistoryService;

    @RequestMapping(value = "/update", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<JobHistoryDTO> updhist(@RequestBody JobHistoryDTO histload) throws Exception {
        return new ResponseEntity<JobHistoryDTO>(JobHistoryService.updateJobHistory(JobHistoryService.JobHistoryDTOToEntity(histload)), HttpStatus.OK);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<JobHistoryDTO> postehist(@RequestBody JobHistoryDTO histload) throws Exception {
        return new ResponseEntity<JobHistoryDTO>(JobHistoryService.addJobHistory(JobHistoryService.JobHistoryDTOToEntity(histload)), HttpStatus.OK);
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
    public List<JobHistoryDTO> findByid(@PathVariable final Long id) throws Exception {
        List<JobHistory> e = JobHistoryService.findJobHistory(id);
        if (e == null) {
            throw new Exception("Employee with this ID doesn´t exist");
        }
        List<JobHistoryDTO> e1 = new ArrayList<JobHistoryDTO>();
        for (int i = 0; i < e.size(); i++)
            e1.add(JobHistoryService.EntityToDTO(e.get(i)));
        return e1;
    }
}
