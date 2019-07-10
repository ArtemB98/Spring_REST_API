package com.example.RestService.Controllers.Services.Repositories;

import com.example.RestService.Controllers.Services.Repositories.Entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<Location, Long> {
    Location findByLocationId(Long id);
}
