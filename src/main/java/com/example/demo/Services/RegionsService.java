package com.example.demo.Services;

import com.example.demo.Entities.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.RegionsRepository;

@Service
public class RegionsService {
    @Autowired
    private RegionsRepository RegionsRepository;

    public Region findRegion(Long id) {
        return RegionsRepository.findByRegionId(id);
    }

    public Region addRegion(Region Region) {
        return RegionsRepository.saveAndFlush(Region);
    }

    public void deleteRegion(Long id) {
        RegionsRepository.deleteById(id);
    }

    public Region updateRegion(Region Region) {
        return RegionsRepository.saveAndFlush(Region);
    }
}
