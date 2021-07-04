package br.com.zupacademy.enricco.casadocodigo.controller.dto;

import br.com.zupacademy.enricco.casadocodigo.model.User;

public class UserDTO {
    private Long id;

    public UserDTO(User user) {
        this.id = user.getId();
    }

    public Long getId() {
        return id;
    }
}
