package com.epam.example.demo.repository;
import com.epam.example.demo.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByNameIgnoreCase(String name);
}
