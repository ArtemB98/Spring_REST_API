package com.example.demo.Services;

import com.example.demo.Entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CountriesRepository;

@Service
public class CountriesService {
    @Autowired
    private CountriesRepository CountriesRepository;

    public Country addCountry(Country Country) {
        return CountriesRepository.saveAndFlush(Country);
    }

    public void deleteCountry(String id) {
        CountriesRepository.deleteById(id);
    }

    public Country updateCountry(Country Country) {
        return CountriesRepository.saveAndFlush(Country);
    }

    public Country findCount(String id) {
        return CountriesRepository.findByCountryId(id);
    }
}
