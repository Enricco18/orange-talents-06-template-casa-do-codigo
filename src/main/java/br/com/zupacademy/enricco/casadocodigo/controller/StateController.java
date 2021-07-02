package br.com.zupacademy.enricco.casadocodigo.controller;

import br.com.zupacademy.enricco.casadocodigo.controller.form.NewStateForm;
import br.com.zupacademy.enricco.casadocodigo.model.Country;
import br.com.zupacademy.enricco.casadocodigo.model.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/state")
public class StateController {
    private Logger logger = LoggerFactory.getLogger(StateController.class);

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createState(@RequestBody @Valid NewStateForm stateForm){
        logger.info("METHOD:POST | PATH: /state | FUNCTION: createState | BODY:" + stateForm.toString());
        Country country = entityManager.find(Country.class,stateForm.getCountry_id());

        State newState = stateForm.toModel(country);

        entityManager.persist(newState);

        return ResponseEntity.ok().build();
    }
}
