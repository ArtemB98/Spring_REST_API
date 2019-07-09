package com.example.demo.Services;

import com.example.demo.Entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.LocationsRepository;

@Service
public class LocationsService {
    @Autowired
    private LocationsRepository LocationsRepository;

    public Location findLocation(Long id) {
        return LocationsRepository.findByLocationId(id);
    }

    public Location addLocation(Location Location) {
        return LocationsRepository.saveAndFlush(Location);
    }

    public void deleteLocation(Long id) {
        LocationsRepository.deleteById(id);
    }

    public Location updateLocation(Location Location) {
        return LocationsRepository.saveAndFlush(Location);
    }
}

