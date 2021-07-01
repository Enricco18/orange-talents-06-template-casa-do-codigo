package br.com.zupacademy.enricco.casadocodigo.controller.dto;

public class DetailedBookAuthorDTO {
    private String name;
    private String description;

    public DetailedBookAuthorDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
