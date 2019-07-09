package com.example.demo.repository;

import com.example.demo.Entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Job, String> {
    Job findByJobId(String id);
}
