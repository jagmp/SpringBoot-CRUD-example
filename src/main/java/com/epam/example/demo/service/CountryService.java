package com.epam.example.demo.service;

import com.epam.example.demo.models.Country;

import java.util.List;

public interface CountryService {

    Country addCountry(Country country) throws Exception;;

    String updateCountry(Country country) throws Exception;

    String deleteCountry(Long id) throws Exception;

    Country getCountry(Long id) throws Exception;

    List<Country> getCountries() throws Exception;
}
