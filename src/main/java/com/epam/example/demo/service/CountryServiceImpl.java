package com.epam.example.demo.service;

import com.epam.example.demo.models.Country;
import com.epam.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public String updateCountry(Country country) throws Exception {
        //check if country already there ot not
        Country existingCountry = getCountry(country.getId());

        // check if already exists or not
        Country getCountryByName = countryRepository.findByNameIgnoreCase(country.getName());

        try {
            // check if Ids are same as updating one
            if (null != getCountryByName && getCountryByName.getId() != country.getId()) {
                throw new Exception("Country with name " + getCountryByName.getName() + " is already exists.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

       Country updatedCountry = countryRepository.saveAndFlush(country);

        return "Country " + updatedCountry.getName() + " updated successfully. ";
    }

    @Override
    public String deleteCountry(Long id) {
        Optional<Country> getCountry = countryRepository.findById(id);
        if (!getCountry.isPresent())
            new Exception("Country not found with Id " + id);

        countryRepository.delete(getCountry.get());

        return "Country " + getCountry.get().getName() + " deleted successfully. ";

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
