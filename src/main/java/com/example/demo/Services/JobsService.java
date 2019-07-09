package com.example.demo.Services;

import com.example.demo.Entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.JobsRepository;

@Service
public class JobsService {
    @Autowired
    private JobsRepository JobsRepository;

    public Job findJob(String id) {
        return JobsRepository.findByJobId(id);
    }

    public Job addJob(Job Job) {
        return JobsRepository.saveAndFlush(Job);
    }

    public void deleteJob(String id) {
        JobsRepository.deleteById(id);
    }

    public Job updateJob(Job Job) {
        return JobsRepository.saveAndFlush(Job);
    }
}
