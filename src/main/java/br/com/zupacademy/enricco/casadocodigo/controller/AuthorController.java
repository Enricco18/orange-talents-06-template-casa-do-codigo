package br.com.zupacademy.enricco.casadocodigo.controller;

import br.com.zupacademy.enricco.casadocodigo.controller.dto.AuthorDTO;
import br.com.zupacademy.enricco.casadocodigo.controller.form.NewAuthorForm;
import br.com.zupacademy.enricco.casadocodigo.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping
    @Transactional
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody @Valid NewAuthorForm authorForm){
        Author newAuthor = authorForm.toModel();

        entityManager.persist(newAuthor);

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.parse(newAuthor);

        return ResponseEntity.ok().body(authorDTO);
    }

}
