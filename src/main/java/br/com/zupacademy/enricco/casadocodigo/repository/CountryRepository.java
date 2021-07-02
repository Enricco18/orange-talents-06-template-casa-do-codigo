package br.com.zupacademy.enricco.casadocodigo.repository;

import br.com.zupacademy.enricco.casadocodigo.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long> {
}
