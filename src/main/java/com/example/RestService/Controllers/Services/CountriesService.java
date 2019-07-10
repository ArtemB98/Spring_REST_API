package com.example.RestService.Controllers.Services;

import com.example.RestService.Controllers.Services.Repositories.Entities.Country;
import com.example.RestService.Controllers.Services.Repositories.CountriesRepository;
import com.example.RestService.Controllers.Services.Repositories.EntityDTOs.CountryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountriesService {
    @Autowired
    private CountriesRepository CountriesRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CountryDTO addCountry(Country Country) {
        return EntityToDTO(CountriesRepository.saveAndFlush(Country));
    }

    public void deleteCountry(String id) {
        CountriesRepository.deleteById(id);
    }

    public CountryDTO updateCountry(Country Country) {
        return EntityToDTO(CountriesRepository.saveAndFlush(Country));
    }

    public Country findCount(String id) {
        return CountriesRepository.findByCountryId(id);
    }

    public CountryDTO EntityToDTO(Country c) {
        return modelMapper.map(c, CountryDTO.class);
    }

    public Country CountryDTOToEntity(CountryDTO c) {
        return modelMapper.map(c, Country.class);
    }
}
