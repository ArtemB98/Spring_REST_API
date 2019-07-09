package com.example.demo.repository;

import com.example.demo.Entities.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {
    List<JobHistory> findAllByEmployeeId(Long id);
}
