package com.example.demo.Services;

import com.example.demo.Entities.Regions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.RegionsRepository;

@Service
public class RegionsService {
    @Autowired
    private RegionsRepository RegionsRepository;

    public Regions findRegion(Long id) {
        return RegionsRepository.findByRegionId(id);
    }

    public Regions addRegion(Regions Region) {
        return RegionsRepository.saveAndFlush(Region);
    }

    public void deleteRegion(Long id) {
        RegionsRepository.deleteById(id);
    }

    public Regions updateRegion(Regions Region) {
        return RegionsRepository.saveAndFlush(Region);
    }
}
