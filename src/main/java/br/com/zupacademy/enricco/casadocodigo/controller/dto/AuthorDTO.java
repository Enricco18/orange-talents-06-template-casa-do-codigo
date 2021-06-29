package br.com.zupacademy.enricco.casadocodigo.controller.dto;

import br.com.zupacademy.enricco.casadocodigo.model.Author;

import java.time.LocalDateTime;

public class AuthorDTO {
    private Long id;
    private String name;
    private String email;
    private String description;
    private LocalDateTime created_at;

    public AuthorDTO(Author author){
        this.id = author.getId();
        this.name = author.getName();
        this.email = author.getEmail();
        this.description = author.getDescription();
        this.created_at = author.getCreated_at();
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }
}
