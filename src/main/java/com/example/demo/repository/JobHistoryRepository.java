package com.example.demo.repository;

import com.example.demo.Entities.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {
    @Query("select b from JobHistory b where b.employeeId = :id")
    List<JobHistory> findByid(@Param("id") Long id);
}
