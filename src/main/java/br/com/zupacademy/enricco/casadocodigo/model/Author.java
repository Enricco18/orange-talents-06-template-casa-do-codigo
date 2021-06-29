package br.com.zupacademy.enricco.casadocodigo.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty @NotBlank
    private String name;

    @NotNull @NotEmpty @NotBlank
    @Email
    private String email;

    @NotNull @NotEmpty @NotBlank
    @Length(max = 400)
    private String description;

    @CreatedDate
    @NotNull
    private LocalDateTime created_at = LocalDateTime.now();

    public Author(@NotBlank String name, @NotBlank @Email String email, @Length(max = 400)  @NotBlank String description) {
        this.name = name;
        this.email = email;
        this.description = description;
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
