package br.com.zupacademy.enricco.casadocodigo.controller.dto;

import br.com.zupacademy.enricco.casadocodigo.model.Category;

public class CategoryDTO {
    private Long id;
    private String name;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public CategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
