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
    public ResponseEntity<List<Country>> getCountries() throws Exception {
        return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody Country country) throws Exception {
        return new ResponseEntity<>(countryService.addCountry(country), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCountry(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(countryService.getCountry(id), HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<String> updateCountry(@RequestBody Country country) throws Exception {
        return new ResponseEntity<>(countryService.updateCountry(country), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(countryService.deleteCountry(id), HttpStatus.OK);
    }


}
