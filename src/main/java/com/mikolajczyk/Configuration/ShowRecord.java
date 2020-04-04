package com.mikolajczyk.Configuration;

import com.mikolajczyk.Components.Book;
import com.mikolajczyk.Components.History;
import com.mikolajczyk.Components.Reader;
import org.hibernate.Query;

import java.io.Serializable;

public class ShowRecord {

    private Reader reader;
    private Book book;
    private History history;

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public History getHistory() {
        return history;
    }

    public History showHistory(Object id){
        return (History) LibraryConfiguration.session.get(History.class, (Serializable) id);
    }

    public Reader showReader(Object id){
        return (Reader) LibraryConfiguration.session.get(Reader.class, (Serializable) id);
    }

    public Book showBook(Object id){
        return (Book) LibraryConfiguration.session.get(Book.class, (Serializable) id);
    }

    public void showSpecialQuery(){

    }

}
