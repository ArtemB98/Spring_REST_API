package com.example.demo.Controllers;


import com.example.demo.Entities.Region;
import com.example.demo.Services.RegionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/regions")
public class RegionController {
    @Autowired
    private RegionsService RegionsService;

    @RequestMapping(value = "/update", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<Region> updereg(@RequestBody Region regload) throws Exception {
        return new ResponseEntity<Region>(RegionsService.updateRegion(regload), HttpStatus.OK);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<Region> postreg(@RequestBody Region regload) throws Exception {
        return new ResponseEntity<Region>(RegionsService.addRegion(regload), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    public void deletereg(@PathVariable final Long id) throws Exception {
        if (RegionsService.findRegion(id) == null) {//удалить историю работы
            throw new Exception("Region to delete doesn´t exist");
        }
        RegionsService.deleteRegion(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Region findByid(@PathVariable final Long id) throws Exception {
        Region e = RegionsService.findRegion(id);
        if (e == null) {
            throw new Exception("Region with this ID doesn´t exist");
        }
        return e;
    }
}
