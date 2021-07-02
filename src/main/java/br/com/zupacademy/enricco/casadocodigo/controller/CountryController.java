package br.com.zupacademy.enricco.casadocodigo.controller;

import br.com.zupacademy.enricco.casadocodigo.controller.form.NewCountryForm;
import br.com.zupacademy.enricco.casadocodigo.model.Country;
import br.com.zupacademy.enricco.casadocodigo.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/country")
public class CountryController {
    private Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping
    public ResponseEntity<?> createCountry(@RequestBody @Valid NewCountryForm newCountryForm){
        logger.info("METHOD:POST | PATH: /country | FUNCTION: createCountry | BODY:" + newCountryForm.toString());

        Country country = newCountryForm.toModel();

        countryRepository.save(country);

        return ResponseEntity.ok().build();
    }
}
