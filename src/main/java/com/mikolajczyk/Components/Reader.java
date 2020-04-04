package com.mikolajczyk.Components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Czytelnik")
public class Reader {

    @Id
    @Column(name = "id_czytelnika")
    private int readerId;

    @Column(name = "imie")
    private String fName;

    @Column(name = "nazwisko")
    private String lName;

    @Column(name = "nr_telefonu")
    private String phoneNumber;

    @Column(name = "adres")
    private String address;

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
