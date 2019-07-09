package com.example.demo.repository;

import com.example.demo.Entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Countries, String> {
    Countries findByCountryId(String id);
}
