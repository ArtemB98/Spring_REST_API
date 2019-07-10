package com.example.RestService.Controllers.Services;

import com.example.RestService.Controllers.Services.Repositories.Entities.Location;
import com.example.RestService.Controllers.Services.Repositories.EntityDTOs.LocationDTO;
import com.example.RestService.Controllers.Services.Repositories.LocationsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationsService {
    @Autowired
    private LocationsRepository LocationsRepository;

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

