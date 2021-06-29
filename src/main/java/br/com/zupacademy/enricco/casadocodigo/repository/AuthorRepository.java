package br.com.zupacademy.enricco.casadocodigo.repository;

import br.com.zupacademy.enricco.casadocodigo.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
    Optional<Author> findByEmail(String email);
}
