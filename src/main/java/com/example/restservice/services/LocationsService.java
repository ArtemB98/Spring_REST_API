package com.example.restservice.services;

import com.example.restservice.entities.Location;
import com.example.restservice.entityDTOs.LocationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationsService {
    @Autowired
    private com.example.restservice.services.repositories.LocationsRepository LocationsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Location findLocation(Long id) {
        return LocationsRepository.findByLocationId(id);
    }

    public LocationDTO addLocation(Location Location) {
        return EntityToDTO(LocationsRepository.saveAndFlush(Location));
    }

    public void deleteLocation(Long id) {
        LocationsRepository.deleteById(id);
    }

    public LocationDTO updateLocation(Location Location) {
        return EntityToDTO(LocationsRepository.saveAndFlush(Location));
    }

    public LocationDTO EntityToDTO(Location c) {
        return modelMapper.map(c, LocationDTO.class);
    }

    public Location LocationDTOToEntity(LocationDTO c) {
        return modelMapper.map(c, Location.class);
    }
}

