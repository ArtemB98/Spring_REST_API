package com.example.RestService.Controllers.Services;

import com.example.RestService.Controllers.Services.Repositories.Entities.Region;
import com.example.RestService.Controllers.Services.Repositories.EntityDTOs.RegionDTO;
import com.example.RestService.Controllers.Services.Repositories.RegionsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionsService {
    @Autowired
    private RegionsRepository RegionsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Region findRegion(Long id) {
        return RegionsRepository.findByRegionId(id);
    }

    public RegionDTO addRegion(Region Region) {
        return EntityToDTO(RegionsRepository.saveAndFlush(Region));
    }

    public void deleteRegion(Long id) {
        RegionsRepository.deleteById(id);
    }

    public RegionDTO updateRegion(Region Region) {
        return EntityToDTO(RegionsRepository.saveAndFlush(Region));
    }

    public RegionDTO EntityToDTO(Region c) {
        return modelMapper.map(c, RegionDTO.class);
    }

    public Region RegionDTOToEntity(RegionDTO c) {
        return modelMapper.map(c, Region.class);
    }
}
