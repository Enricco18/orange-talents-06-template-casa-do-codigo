package br.com.zupacademy.enricco.casadocodigo.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @NotEmpty @NotNull
    private String name;
    @NotNull
    @ManyToOne
    @Valid
    private Country country;

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    @Deprecated
    private State() {
    }
}
