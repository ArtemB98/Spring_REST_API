package com.example.RestService.Controllers.Services;

import com.example.RestService.Controllers.Services.Repositories.Entities.JobHistory;
import com.example.RestService.Controllers.Services.Repositories.EntityDTOs.JobHistoryDTO;
import com.example.RestService.Controllers.Services.Repositories.JobHistoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobHistoryService {
    @Autowired
    private JobHistoryRepository JobHistoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<JobHistory> findJobHistory(Long id) {
        return JobHistoryRepository.findAllByEmployeeId(id);
    }

    public JobHistoryDTO addJobHistory(JobHistory JobHistory) {
        return EntityToDTO(JobHistoryRepository.saveAndFlush(JobHistory));
    }

    public void deleteJobHistory(Long id) {
        JobHistoryRepository.deleteById(id);
    }

    public JobHistoryDTO updateJobHistory(JobHistory JobHistory) {
        return EntityToDTO(JobHistoryRepository.saveAndFlush(JobHistory));
    }

    public JobHistoryDTO EntityToDTO(JobHistory c) {
        return modelMapper.map(c, JobHistoryDTO.class);
    }

    public JobHistory JobHistoryDTOToEntity(JobHistoryDTO c) {
        return modelMapper.map(c, JobHistory.class);
    }
}
