package com.example.restservice.services;

import com.example.restservice.entities.Country;
import com.example.restservice.entityDTOs.CountryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountriesService {
    @Autowired
    private com.example.restservice.services.repositories.CountriesRepository CountriesRepository;

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
