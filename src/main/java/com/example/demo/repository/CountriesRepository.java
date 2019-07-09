package com.example.demo.repository;

import com.example.demo.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Country, String> {
    Country findByCountryId(String id);
}
