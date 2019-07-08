package com.example.demo.Controllers;


import com.example.demo.Entities.Countries;
import com.example.demo.Services.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private CountriesService CountryService;

    @RequestMapping(value = "/update", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE},headers = "Accept=application/json")
    public ResponseEntity<Countries> updcon(@RequestBody Countries conload) throws Exception{
        return new ResponseEntity<Countries>(CountryService.updateCountry(conload), HttpStatus.OK);
    }
    @RequestMapping(value = "/post", method = RequestMethod.POST,  produces = {MediaType.APPLICATION_JSON_VALUE},headers = "Accept=application/json")
    public ResponseEntity<Countries> postcount(@RequestBody Countries conload) throws Exception{
        return new ResponseEntity<Countries>(CountryService.addCountry(conload), HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,  produces = {MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
    public void deletcount(@PathVariable final String id) throws Exception{
        if (CountryService.findCount(id) == null){//удалить историю работы
            throw new Exception("Country to delete doesn´t exist");
        }
        CountryService.deleteCountry(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET,  produces = {MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Countries findByid(@PathVariable final String id)  throws Exception{
        Countries e = CountryService.findCount(id);
        if (e == null){
            throw new Exception("Country with this ID doesn´t exist");
        }
        return e;
    }
}
