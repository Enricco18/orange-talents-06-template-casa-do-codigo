package br.com.zupacademy.enricco.casadocodigo.repository;

import br.com.zupacademy.enricco.casadocodigo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
}
