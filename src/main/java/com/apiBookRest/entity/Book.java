package com.apiBookRest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ACE
 */
@Entity
@Table(name = "Book1")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nameBook")
    private String nameBook;

    @Column(name = "descriptionbook")
    private String descriptionbook;

    @Column(name = "publicationdate")
    private String publicationDate;

    @Column(name = "authorbook")
    private String authorbook;

    @Column(name = "numbercopies")
    private int numberCopies;

    @Column(name = "cost")
    private Float cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getDescriptionbook() {
        return descriptionbook;
    }

    public void setDescriptionbook(String descriptionbook) {
        this.descriptionbook = descriptionbook;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthorbook() {
        return authorbook;
    }

    public void setAuthorbook(String authorbook) {
        this.authorbook = authorbook;
    }

    public int getNumberCopies() {
        return numberCopies;
    }

    public void setNumberCopies(int numbercopies) {
        this.numberCopies = numbercopies;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}
