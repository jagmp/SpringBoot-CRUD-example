package com.epam.example.demo.service;

import com.epam.example.demo.models.Country;
import com.epam.example.demo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {


    private CountryRepository countryRepository;

    @Override
    public Country addCountry(Country country) {

        Country existingCountry = countryRepository.findByNameIgnoreCase(country.getName());
        if (existingCountry != null) {
            throw new DuplicateCountryException("Country with name " + existingCountry.getName() + " already exists.");
        }
        return countryRepository.save(country);

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
