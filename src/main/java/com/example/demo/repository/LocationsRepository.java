package com.example.demo.repository;

import com.example.demo.Entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<Location, Long> {
    Location findByLocationId(Long id);
}
