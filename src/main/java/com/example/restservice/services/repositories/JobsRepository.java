package com.example.restservice.services.repositories;

import com.example.restservice.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Job, String> {
    Job findByJobId(String id);
}
