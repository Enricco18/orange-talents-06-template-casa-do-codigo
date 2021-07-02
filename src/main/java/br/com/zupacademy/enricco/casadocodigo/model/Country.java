package br.com.zupacademy.enricco.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty @NotBlank
    @Column(unique = true)
    private String name;

    public Country(@NotBlank String name) {
        this.name = name;
    }

    @Deprecated
    private Country() {
    }
}
