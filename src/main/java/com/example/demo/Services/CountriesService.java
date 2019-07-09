package com.example.demo.Services;

import com.example.demo.Entities.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CountriesRepository;

@Service
public class CountriesService {
    @Autowired
    private CountriesRepository CountriesRepository;

    public Countries addCountry(Countries Country) {
        return CountriesRepository.saveAndFlush(Country);
    }

    public void deleteCountry(String id) {
        CountriesRepository.deleteById(id);
    }

    public Countries updateCountry(Countries Country) {
        return CountriesRepository.saveAndFlush(Country);
    }

    public Countries findCount(String id) {
        return CountriesRepository.findByCountryId(id);
    }
}
