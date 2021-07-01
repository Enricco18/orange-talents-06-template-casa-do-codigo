package br.com.zupacademy.enricco.casadocodigo.controller.dto;

import java.math.BigDecimal;

public class DetailedBookDTO {
    private String title;
    private String lsbn;
    private String resume;
    private String summary;
    private BigDecimal price;
    private Integer nPages;

    private DetailedBookAuthorDTO author;

    public DetailedBookDTO(String title, String lsbn, String resume, String summary, BigDecimal price, int nPages, String author_name, String author_description) {
        this.title = title;
        this.lsbn = lsbn;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.nPages = nPages;
        this.author =  new DetailedBookAuthorDTO(author_name,author_description);
    }

    @Deprecated
    private DetailedBookDTO() {
    }

    public String getTitle() {
        return title;
    }

    public String getLsbn() {
        return lsbn;
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

    public DetailedBookAuthorDTO getAuthor() {
        return author;
    }
}
