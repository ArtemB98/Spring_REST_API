package com.example.RestService.Controllers;

import com.example.RestService.Controllers.Services.LocationsService;
import com.example.RestService.Controllers.Services.Repositories.Entities.Location;
import com.example.RestService.Controllers.Services.Repositories.EntityDTOs.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    private LocationsService LocationsService;

    @RequestMapping(value = "/update", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<LocationDTO> updloc(@RequestBody LocationDTO locload) throws Exception {
        return new ResponseEntity<LocationDTO>(LocationsService.updateLocation(LocationsService.LocationDTOToEntity(locload)), HttpStatus.OK);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<LocationDTO> postloc(@RequestBody LocationDTO locload) throws Exception {
        return new ResponseEntity<LocationDTO>(LocationsService.addLocation(LocationsService.LocationDTOToEntity(locload)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    public void deleteloc(@PathVariable final Long id) throws Exception {
        if (LocationsService.findLocation(id) == null) {//удалить историю работы
            throw new Exception("Employee to delete doesn´t exist");
        }
        LocationsService.deleteLocation(id);
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.GET,  produces = {MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LocationDTO findByid(@PathVariable final Long id) throws Exception {
        Location e = LocationsService.findLocation(id);
        if (e == null) {
            throw new Exception("Employee with this ID doesn´t exist");
        }
        return LocationsService.EntityToDTO(e);
    }
}
