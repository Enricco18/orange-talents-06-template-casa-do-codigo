package br.com.zupacademy.enricco.casadocodigo.controller.form;

import br.com.zupacademy.enricco.casadocodigo.model.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewCategoryForm {
    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    @Deprecated
    public NewCategoryForm() {
    }

    public NewCategoryForm(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Category toModel(){
        return new Category(this.name);
    }

}
