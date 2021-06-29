package br.com.zupacademy.enricco.casadocodigo.controller;

import br.com.zupacademy.enricco.casadocodigo.controller.dto.AuthorDTO;
import br.com.zupacademy.enricco.casadocodigo.controller.form.NewAuthorForm;
import br.com.zupacademy.enricco.casadocodigo.middleware.validator.EmailRegisteredValidation;
import br.com.zupacademy.enricco.casadocodigo.model.Author;
import br.com.zupacademy.enricco.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private EmailRegisteredValidation emailRegisteredValidation;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailRegisteredValidation);
    }

    @PostMapping
    public ResponseEntity<?> createAuthor(@RequestBody @Valid NewAuthorForm authorForm){
        Author newAuthor = authorForm.toModel();

        authorRepository.save(newAuthor);


        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.parse(newAuthor);

        return ResponseEntity.ok().body(authorDTO);
    }

}
