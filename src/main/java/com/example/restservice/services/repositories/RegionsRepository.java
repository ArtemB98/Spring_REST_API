package com.example.restservice.services.repositories;

import com.example.restservice.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsRepository extends JpaRepository<Region, Long> {
    Region findByRegionId(Long id);
}
