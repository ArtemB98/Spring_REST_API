package com.example.demo.repository;

import com.example.demo.Entities.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsRepository extends JpaRepository<Regions, Long> {
    Regions findByRegionId(Long id);
}
