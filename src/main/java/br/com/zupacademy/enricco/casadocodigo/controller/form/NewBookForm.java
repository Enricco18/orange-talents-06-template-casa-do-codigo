package br.com.zupacademy.enricco.casadocodigo.controller.form;

import br.com.zupacademy.enricco.casadocodigo.model.Author;
import br.com.zupacademy.enricco.casadocodigo.model.Book;
import br.com.zupacademy.enricco.casadocodigo.model.Category;
import br.com.zupacademy.enricco.casadocodigo.validation.EntityExists;
import br.com.zupacademy.enricco.casadocodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class NewBookForm {
    @NotNull @NotEmpty @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "lsbn")
    private String lsbn;

    @NotNull @NotEmpty @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private String title;

    @NotNull @NotEmpty @NotBlank
    @Length(max=500)
    private String resume;

    private String summary;

    @NotNull @Min(20)
    private BigDecimal price;

    @NotNull @Min(100)
    private Integer nPages;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicationDate;

    @NotNull
    @EntityExists(domainClass = Author.class)
    private Long author_id;

    @NotNull
    @EntityExists(domainClass = Category.class)
    private Long category_id;

    public Book toModel(Author author, Category category){
        Book newBook =  new Book(this.lsbn,this.title,this.resume,this.summary,this.price,this.nPages,this.publicationDate,author,category);
        return newBook;
    }

    @Override
    public String toString() {
        return "NewBookForm{" +
                "lsbn='" + lsbn + '\'' +
                ", title='" + title + '\'' +
                ", resume='" + resume + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", nPages=" + nPages +
                ", publicationDate=" + publicationDate +
                ", author_id=" + author_id +
                ", category_id=" + category_id +
                '}';
    }

    public NewBookForm(@NotBlank String lsbn,
                       @NotBlank String title,
                       @NotBlank @Length(max=500) String resume,
                       String summary,
                       @NotNull @Min(20)BigDecimal price,
                       @NotNull @Min(100) Integer nPages,
                       @NotNull LocalDate publicationDate,
                       @NotNull Long author_id,
                       @NotNull Long category_id) {
        this.lsbn = lsbn;
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.nPages = nPages;
        this.publicationDate = publicationDate;
        this.author_id = author_id;
        this.category_id = category_id;
    }

    public NewBookForm() {
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

    public Long getAuthor_id() {
        return author_id;
    }

    public Long getCategory_id() {
        return category_id;
    }
}
