package com.example.RestService.Controllers.Services.Repositories;

import com.example.RestService.Controllers.Services.Repositories.Entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsRepository extends JpaRepository<Region, Long> {
    Region findByRegionId(Long id);
}
