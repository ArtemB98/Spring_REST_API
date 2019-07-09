package com.example.demo.Services;

import com.example.demo.Entities.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.LocationsRepository;

@Service
public class LocationsService {
    @Autowired
    private LocationsRepository LocationsRepository;

    public Locations findLocation(Long id) {
        return LocationsRepository.findByLocationId(id);
    }

    public Locations addLocation(Locations Location) {
        return LocationsRepository.saveAndFlush(Location);
    }

    public void deleteLocation(Long id) {
        LocationsRepository.deleteById(id);
    }

    public Locations updateLocation(Locations Location) {
        return LocationsRepository.saveAndFlush(Location);
    }
}

