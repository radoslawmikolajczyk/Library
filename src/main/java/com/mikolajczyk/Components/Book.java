package com.mikolajczyk.Components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ksiazka")
public class Book {

    @Id
    @Column(name = "id_ksiazki")
    private int bookId;

    @Column(name = "autor")
    private String author;

    @Column(name = "tytul")
    private String title;

    @Column(name = "wydawnictwo")
    private String publisher;

    @Column(name = "rok_wydania")
    private int year;

    @Column(name = "ilosc_sztuk")
    private int number;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
