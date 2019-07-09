package com.example.demo.repository;

import com.example.demo.Entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsRepository extends JpaRepository<Region, Long> {
    Region findByRegionId(Long id);
}
