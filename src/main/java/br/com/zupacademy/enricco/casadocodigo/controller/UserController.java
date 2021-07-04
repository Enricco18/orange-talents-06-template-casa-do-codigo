package br.com.zupacademy.enricco.casadocodigo.controller;

import br.com.zupacademy.enricco.casadocodigo.controller.dto.UserDTO;
import br.com.zupacademy.enricco.casadocodigo.controller.form.NewUserForm;
import br.com.zupacademy.enricco.casadocodigo.model.User;
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
@RequestMapping("/user")
public class UserController {
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid NewUserForm newUserForm){

        User user = newUserForm.toModel(entityManager);
        entityManager.persist(user);

        return ResponseEntity.ok(new UserDTO(user));
    }
}
