package com.mikolajczyk.Components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Wypozyczenia_zwroty")
public class History implements Serializable {

    @Id
    @Column(name = "id_ksiazki")
    private int bookId;

    @Id
    @Column(name = "id_czytelnika")
    private int readerId;

    @Column(name = "data_wypozyczenia")
    private Date lendDate;

    @Column(name = "data_oddania")
    private Date returnDate;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
