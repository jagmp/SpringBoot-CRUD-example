package com.epam.example.demo.service;

import com.epam.example.demo.models.Country;
import com.epam.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country addCountry(Country country) {

        Country getCountry = countryRepository.findByNameIgnoreCase(country.getName());
        /* TODO:: fix code */
          /*if(null != getCountry)
            try {
                throw new Exception("Country with name "+getCountry.getName()+" is already exists.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }*/
        return getCountry != null ? getCountry : countryRepository.save(country);

    }

    @Override
    public Country updateCountry(Country country) {
        return null;
    }

    @Override
    public String deleteCountry(Country country) {
        return null;
    }

    @Override
    public Country getCountry(final Long id) throws Exception {
        return countryRepository.findById(id).orElseThrow(() -> new Exception("Country not found with Id " + id));
    }

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
