package com.epam.example.demo.controller;

import com.epam.example.demo.models.Country;
import com.epam.example.demo.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@AllArgsConstructor
public class CountryController {

    CountryService countryService;


    @GetMapping
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        return new ResponseEntity<>(countryService.addCountry(country), HttpStatus.OK);
    }



}
