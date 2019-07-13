package com.example.restservice.services.repositories;

import com.example.restservice.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<Location, Long> {
    Location findByLocationId(Long id);
}
