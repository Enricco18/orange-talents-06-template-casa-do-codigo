package br.com.zupacademy.enricco.casadocodigo.model;

import br.com.zupacademy.enricco.casadocodigo.validation.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty @NotBlank
    @Column(unique = true)
    private String email;

    @NotNull @NotEmpty @NotBlank
    private String name;

    @NotNull @NotEmpty @NotBlank
    private String lastname;

    @NotNull @NotEmpty @NotBlank
    @Document
    @Column(unique = true)
    private String document;

    @NotNull @NotEmpty @NotBlank
    private String address;

    @NotNull @NotEmpty @NotBlank
    private String complement;

    @NotNull @NotEmpty @NotBlank
    private String city;

    @ManyToOne
    @NotNull
    private Country country;

    @ManyToOne
    private State state;

    @NotNull @NotEmpty @NotBlank
    private String telephone;

    @NotNull @NotEmpty @NotBlank
    private String cep;

    public User(String email, String name, String lastname, String document, String address, String complement, String city, Country country, State state, String telephone, String cep) {
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.telephone = telephone;
        this.cep = cep;
    }

    @Deprecated
    private User() {
    }

    public Long getId() {
        return id;
    }
}
