package br.com.zupacademy.enricco.casadocodigo.controller;

import br.com.zupacademy.enricco.casadocodigo.controller.form.NewBookForm;
import br.com.zupacademy.enricco.casadocodigo.model.Author;
import br.com.zupacademy.enricco.casadocodigo.model.Book;
import br.com.zupacademy.enricco.casadocodigo.model.Category;
import br.com.zupacademy.enricco.casadocodigo.repository.AuthorRepository;
import br.com.zupacademy.enricco.casadocodigo.repository.BookRepository;
import br.com.zupacademy.enricco.casadocodigo.repository.CategoryRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/book")
public class BookController {
    private Logger logger= LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody @Valid NewBookForm bookForm){

        logger.info(bookForm.toString());

        Author author = authorRepository.findById(bookForm.getAuthor_id()).get();
        Category category = categoryRepository.findById(bookForm.getCategory_id()).get();

        Book newBook = bookForm.toModel(author,category);
        bookRepository.save(newBook);


        return ResponseEntity.ok().build();
    }

}
