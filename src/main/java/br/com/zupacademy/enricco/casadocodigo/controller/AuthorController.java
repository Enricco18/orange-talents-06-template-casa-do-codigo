package br.com.zupacademy.enricco.casadocodigo.controller;

import br.com.zupacademy.enricco.casadocodigo.controller.form.NewAuthorForm;
import br.com.zupacademy.enricco.casadocodigo.model.Author;
import br.com.zupacademy.enricco.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

//    public AuthorController(AuthorRepository authorRepository) {
//        this.authorRepository = authorRepository;
//    }

    @PostMapping
    public ResponseEntity<?> createAuthor(@RequestBody @Valid NewAuthorForm authorForm){
        Author newAuthor = authorForm.toModel();

        authorRepository.save(newAuthor);

        return ResponseEntity.ok().build();
    }

}
