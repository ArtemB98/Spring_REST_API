package com.example.restservice.services.repositories;

import com.example.restservice.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Country, String> {
    Country findByCountryId(String id);
}
