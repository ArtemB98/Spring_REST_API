package com.example.restservice.services;

import com.example.restservice.entities.Job;
import com.example.restservice.entityDTOs.JobDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsService {
    @Autowired
    private com.example.restservice.services.repositories.JobsRepository JobsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Job findJob(String id) {
        return JobsRepository.findByJobId(id);
    }

    public JobDTO addJob(Job Job) {
        return EntityToDTO(JobsRepository.saveAndFlush(Job));
    }

    public void deleteJob(String id) {
        JobsRepository.deleteById(id);
    }

    public JobDTO updateJob(Job Job) {
        return EntityToDTO(JobsRepository.saveAndFlush(Job));
    }

    public JobDTO EntityToDTO(Job c) {
        return modelMapper.map(c, JobDTO.class);
    }

    public Job JobDTOToEntity(JobDTO c) {
        return modelMapper.map(c, Job.class);
    }
}
