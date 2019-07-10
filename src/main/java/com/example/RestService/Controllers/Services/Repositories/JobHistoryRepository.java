package com.example.RestService.Controllers.Services.Repositories;

import com.example.RestService.Controllers.Services.Repositories.Entities.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {
    List<JobHistory> findAllByEmployeeId(Long id);
}
