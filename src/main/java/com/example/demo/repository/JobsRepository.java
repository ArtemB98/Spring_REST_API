package com.example.demo.repository;
import com.example.demo.Entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobsRepository extends JpaRepository<Jobs, String> {
    @Query("select b from Jobs b where b.jobId = :id")
    Jobs findByid(@Param("id") String id);
}
