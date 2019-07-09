package com.example.demo.repository;

import com.example.demo.Entities.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegionsRepository extends JpaRepository<Regions, Long> {
    @Query("select b from Regions b where b.regionId = :id")
    Regions findByid(@Param("id") Long id);
}
