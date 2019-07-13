package com.example.restservice.services.repositories;

import com.example.restservice.entities.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {
    List<JobHistory> findAllByEmployeeId(Long id);
}
