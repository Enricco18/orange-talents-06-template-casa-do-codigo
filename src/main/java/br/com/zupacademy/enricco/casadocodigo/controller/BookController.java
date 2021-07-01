package br.com.zupacademy.enricco.casadocodigo.controller;

import br.com.zupacademy.enricco.casadocodigo.controller.dto.BookDTO;
import br.com.zupacademy.enricco.casadocodigo.controller.dto.DetailedBookAuthorDTO;
import br.com.zupacademy.enricco.casadocodigo.controller.dto.DetailedBookDTO;
import br.com.zupacademy.enricco.casadocodigo.controller.form.NewBookForm;
import br.com.zupacademy.enricco.casadocodigo.model.Author;
import br.com.zupacademy.enricco.casadocodigo.model.Book;
import br.com.zupacademy.enricco.casadocodigo.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    private Logger logger= LoggerFactory.getLogger(BookController.class);

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    @Transactional
    public ResponseEntity<List<BookDTO>> getAllBooks(){

        logger.info("METHOD:GET | PATH: /book | FUNCTION: GetAllBooks");

        Query query = entityManager.createQuery("SELECT new "+BookDTO.class.getName()+"(b.id,b.title) FROM Book b");

        List<BookDTO> results = query.getResultList();

        return  ResponseEntity.ok().body(results);
    }

    @GetMapping("/{id}")
    @Transactional
    public  ResponseEntity<DetailedBookDTO> getBookById(@PathVariable("id") Long id){
        logger.info("METHOD:GET | PATH: /book | FUNCTION: getBookById | PARAMS: "+ id.toString());

        Query query = entityManager.createQuery("SELECT new "+ DetailedBookDTO.class.getName()+
                "(b.title,b.lsbn,b.resume,b.summary,b.price,b.nPages,b.author.name,b.author.description) FROM Book b WHERE id=:id");

        query.setParameter("id",id);

        List<DetailedBookDTO> detailedBookDTOS = query.getResultList();

        if(detailedBookDTOS.isEmpty()){
            logger.error("Not Found: BOOK - "+ id.toString());
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(detailedBookDTOS.get(0));

    }


    @PostMapping
    @Transactional
    public ResponseEntity<?> createBook(@RequestBody @Valid NewBookForm bookForm) {

        logger.info("METHOD:POST | PATH: /book | FUNCTION: createBook | BODY:" + bookForm.toString());

        Author author = entityManager.find(Author.class,bookForm.getAuthor_id());
        Category category = entityManager.find(Category.class,bookForm.getCategory_id());

        Book newBook = bookForm.toModel(author,category);
        entityManager.persist(newBook);


        return ResponseEntity.ok().build();
    }

}
