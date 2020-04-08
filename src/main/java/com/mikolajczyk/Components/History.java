package com.mikolajczyk.Components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Wypozyczenia_zwroty")
public class History{

    @Id
    @Column(name = "id_wypozyczenia")
    private int historyId;

    @Column(name = "imie")
    private String fName;

    @Column(name = "nazwisko")
    private String lName;

    @Column(name = "tytul")
    private String title;

    @Column(name = "autor")
    private String author;

    @Column(name = "data_wypozyczenia")
    private String lendDate;


    public String getLendDate() {
        return lendDate;
    }

    public void setLendDate(String lendDate) {
        this.lendDate = lendDate;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }
}
