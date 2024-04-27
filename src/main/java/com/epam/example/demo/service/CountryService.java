package com.epam.example.demo.service;

import com.epam.example.demo.models.Country;

import java.util.List;

public interface CountryService {

    Country addCountry(Country country);

    Country updateCountry(Country country);

    String deleteCountry(Country country);

    Country getCountry(Long id) throws Exception;

    List<Country> getCountries();
}
