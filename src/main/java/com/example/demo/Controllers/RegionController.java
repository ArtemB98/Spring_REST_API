package com.example.demo.Controllers;


import com.example.demo.Entities.Regions;
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
    public ResponseEntity<Regions> updereg(@RequestBody Regions regload) throws Exception {
        return new ResponseEntity<Regions>(RegionsService.updateRegion(regload), HttpStatus.OK);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<Regions> postreg(@RequestBody Regions regload) throws Exception {
        return new ResponseEntity<Regions>(RegionsService.addRegion(regload), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    public void deletereg(@PathVariable final Long id) throws Exception {
        if (RegionsService.findRegion(id) == null) {//удалить историю работы
            throw new Exception("Regions to delete doesn´t exist");
        }
        RegionsService.deleteRegion(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Regions findByid(@PathVariable final Long id) throws Exception {
        Regions e = RegionsService.findRegion(id);
        if (e == null) {
            throw new Exception("Region with this ID doesn´t exist");
        }
        return e;
    }
}
