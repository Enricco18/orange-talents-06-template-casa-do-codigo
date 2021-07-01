package br.com.zupacademy.enricco.casadocodigo.controller.dto;

public class BookDTO {
    private Long id;
    private String title;

    public BookDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
