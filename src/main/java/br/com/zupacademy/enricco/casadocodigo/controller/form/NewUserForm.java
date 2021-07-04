package br.com.zupacademy.enricco.casadocodigo.controller.form;

import br.com.zupacademy.enricco.casadocodigo.model.Country;
import br.com.zupacademy.enricco.casadocodigo.model.State;
import br.com.zupacademy.enricco.casadocodigo.model.User;
import br.com.zupacademy.enricco.casadocodigo.validation.*;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@StateBelongsToCountry
@IfCountryHasStateThanStateNotNull
public class NewUserForm implements CountryStateValidatorInterface {
    @NotNull @NotEmpty @NotBlank
    @UniqueValue(domainClass = User.class,fieldName = "email")
    private String email;

    @NotNull @NotEmpty @NotBlank
    private String name;

    @NotNull @NotEmpty @NotBlank
    private String lastname;

    @NotNull @NotEmpty @NotBlank
    @Document
    @UniqueValue(domainClass = User.class,fieldName = "document")
    private String document;

    @NotNull @NotEmpty @NotBlank
    private String address;

    @NotNull @NotEmpty @NotBlank
    private String complement;

    @NotNull @NotEmpty @NotBlank
    private String city;

    @ManyToOne
    @NotNull
    @EntityExists(domainClass = Country.class)
    private Long country_id;

    @ManyToOne
    private Long state_id;

    @NotNull @NotEmpty @NotBlank
    private String telephone;

    @NotNull @NotEmpty @NotBlank
    private String cep;

    public NewUserForm(@NotBlank String email,
                       @NotBlank String name,
                       @NotBlank String lastname,
                       @NotBlank String document,
                       @NotBlank String address,
                       @NotBlank String complement,
                       @NotBlank String city,
                       @NotNull Long country_id,
                       Long state_id,
                       @NotBlank String telephone,
                       @NotBlank String cep) {
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country_id = country_id;
        this.state_id = state_id;
        this.telephone = telephone;
        this.cep = cep;
    }

    public User toModel(EntityManager entityManager){
        State state = null;
        Country country = entityManager.find(Country.class, this.country_id);

        if(this.state_id!=null){
            state = entityManager.find(State.class, this.state_id);
        }

        User user = new User(
                this.email,
                this.name,
                this.lastname,
                this.document,
                this.address,
                this.complement,
                this.city,
                country,
                state,
                this.telephone,
                this.cep
        );
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public Long getState_id() {
        return state_id;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCep() {
        return cep;
    }
}
