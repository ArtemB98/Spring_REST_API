package com.example.demo.Services;

import com.example.demo.Entities.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.JobsRepository;

@Service
public class JobsService
{
    @Autowired
    private JobsRepository JobsRepository;
    public Jobs findJob(String id) { return JobsRepository.findByid(id); }
    public Jobs addJob(Jobs Job) {
        return JobsRepository.saveAndFlush(Job);
    }
    public void deleteJob(String id) { JobsRepository.deleteById(id); }
    public Jobs updateJob(Jobs Job) {
        return JobsRepository.saveAndFlush(Job);
    }
}
