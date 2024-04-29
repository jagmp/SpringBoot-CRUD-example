package demo.service;

import com.epam.example.demo.models.Country;
import com.epam.example.demo.repository.CountryRepository;
import com.epam.example.demo.util.AlreadyExistsException;
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
        if (null != getCountry) throw new AlreadyExistsException("Country with name "+getCountry.getName()+" is already exists.");
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
