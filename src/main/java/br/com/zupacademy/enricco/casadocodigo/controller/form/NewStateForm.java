package br.com.zupacademy.enricco.casadocodigo.controller.form;

import br.com.zupacademy.enricco.casadocodigo.model.Country;
import br.com.zupacademy.enricco.casadocodigo.model.State;
import br.com.zupacademy.enricco.casadocodigo.validation.EntityExists;
import br.com.zupacademy.enricco.casadocodigo.validation.UniqueInThatRelation;
import br.com.zupacademy.enricco.casadocodigo.validation.UniqueInThatRelationInterface;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@UniqueInThatRelation(uniqueClass = State.class,uniqueField = "name"
                    ,relationClass = Country.class, relationName = "country", relationField = "id")
public class NewStateForm implements UniqueInThatRelationInterface<String,Long> {
    @NotBlank @NotEmpty @NotNull
    private String name;
    @EntityExists(domainClass = Country.class)
    private Long country_id;

    @Override
    public String toString() {
        return "NewStateForm{" +
                "name='" + name + '\'' +
                ", country_id=" + country_id +
                '}';
    }

    public String getName() {
        return name;
    }

    public Long getCountry_id() {
        return country_id;
    }

    @Override
    public String getUniqueValue() {
        return name;
    }

    @Override
    public Long getRelationValue() {
        return country_id;
    }

    public State toModel(Country country) {
        return new State(name,country);
    }
}
