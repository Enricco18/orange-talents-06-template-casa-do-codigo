package br.com.zupacademy.enricco.casadocodigo.controller.form;

import br.com.zupacademy.enricco.casadocodigo.model.Country;
import br.com.zupacademy.enricco.casadocodigo.validation.UniqueValue;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewCountryForm {
    @NotNull @NotEmpty @NotBlank
    @UniqueValue(domainClass = Country.class,fieldName = "name")
    private String name;

    public Country toModel(){
        return new Country(this.name);
    }

    @Override
    public String toString() {
        return "NewCountryForm{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
