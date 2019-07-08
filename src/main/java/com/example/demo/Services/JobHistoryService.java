package com.example.demo.Services;

import com.example.demo.Entities.JobHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.JobHistoryRepository;

import java.util.List;

@Service
public class JobHistoryService
{
    @Autowired
    private JobHistoryRepository JobHistoryRepository;
    public List<JobHistory> findJobHistory(Long id) { return JobHistoryRepository.findByid(id); }
    public JobHistory addJobHistory(JobHistory JobHistory) {
        return JobHistoryRepository.saveAndFlush(JobHistory);
    }
    public void deleteJobHistory(Long id) {
        JobHistoryRepository.deleteById(id);
    }
    public JobHistory updateJobHistory(JobHistory JobHistory) {
        return JobHistoryRepository.saveAndFlush(JobHistory);
    }
}
