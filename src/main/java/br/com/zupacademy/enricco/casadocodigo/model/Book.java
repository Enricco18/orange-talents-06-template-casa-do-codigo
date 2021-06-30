package br.com.zupacademy.enricco.casadocodigo.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty @NotBlank
    @Column(unique = true)
    private String lsbn;

    @NotNull @NotEmpty @NotBlank
    @Column(unique = true)
    private String title;

    @NotNull @NotEmpty @NotBlank
    @Length(max=500)
    private String resume;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @NotNull
    @Min(20)
    private BigDecimal price;

    @NotNull
    @Min(100)
    private Integer nPages;
    private LocalDate publicationDate;

    @NotNull
    @ManyToOne
    private Author author;

    @NotNull
    @ManyToOne
    private Category category;

    public Book(String lsbn, String title, String resume, String summary, BigDecimal price, Integer nPages, LocalDate publicationDate, Author author, Category category) {
        this.lsbn = lsbn;
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.nPages = nPages;
        this.publicationDate = publicationDate;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getLsbn() {
        return lsbn;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getnPages() {
        return nPages;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }
}
