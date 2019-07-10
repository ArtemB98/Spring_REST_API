package com.example.RestService.Controllers.Services.Repositories;

import com.example.RestService.Controllers.Services.Repositories.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Country, String> {
    Country findByCountryId(String id);
}
