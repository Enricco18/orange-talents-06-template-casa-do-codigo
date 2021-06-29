package br.com.zupacademy.enricco.casadocodigo.controller.form;

import br.com.zupacademy.enricco.casadocodigo.model.Author;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewAuthorForm {
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @NotNull @NotEmpty @NotBlank
    @Email
    private String email;

    @NotNull @NotEmpty @NotBlank
    @Length(max = 400)
    private String description;

    @Deprecated
    public NewAuthorForm() {
    }

    public NewAuthorForm(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author toModel(){
        return new Author(this.name,this.email,this.description);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }
}
