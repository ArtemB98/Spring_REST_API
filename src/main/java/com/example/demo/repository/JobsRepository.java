package com.example.demo.repository;

import com.example.demo.Entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs, String> {
    Jobs findByJobId(String id);
}
