package com.mikolajczyk.Configuration;

import com.mikolajczyk.Components.Book;
import com.mikolajczyk.Components.History;
import com.mikolajczyk.Components.Reader;
import org.hibernate.Query;

public class DeleteRecord {

    private Reader reader;
    private Book book;
    private History history;

    public DeleteRecord(Reader reader){
        this.reader = reader;
    }

    public DeleteRecord(Book book){
        this.book = book;
    }

    public DeleteRecord(History history){
        this.history = history;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public History getHistory() {
        return history;
    }

    public void deleteHistory(){
        String select = String.format("Delete from Wypozyczenia_zwroty where imie='%s' and nazwisko='%s' and autor='%s' and tytul='%s'",
                history.getfName(),history.getlName(),history.getAuthor(),history.getTitle());
        Query query = LibraryConfiguration.session.
                createSQLQuery(select);
        query.executeUpdate();
    }

    public void deleteBook(){
        String select = String.format("Delete from Ksiazka where autor='%s' and tytul='%s'",
                book.getAuthor(),book.getTitle());
        Query query = LibraryConfiguration.session.
                createSQLQuery(select);
        query.executeUpdate();
    }

    public void deleteReader(){
        String select = String.format("Delete from Czytelnik where imie='%s' and nazwisko='%s' and nr_telefonu='%s'",
                reader.getfName(),reader.getlName(),reader.getPhoneNumber());
        Query query = LibraryConfiguration.session.
                createSQLQuery(select);
        query.executeUpdate();
    }

}
