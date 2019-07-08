package com.example.demo.repository;
import com.example.demo.Entities.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationsRepository  extends JpaRepository<Locations, Long> {
    @Query("select b from Locations b where b.locationId = :id")
    Locations findByid(@Param("id") Long id);
}
