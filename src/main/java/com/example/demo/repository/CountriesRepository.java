package com.example.demo.repository;

import com.example.demo.Entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CountriesRepository extends JpaRepository<Countries, String> {
    @Query("select b from Countries b where b.countryId = :id")
    Countries findByid(@Param("id") String id);

    Countries findByCountryId(String id);
}
