package com.mikolajczyk.Configuration;

import com.mikolajczyk.Components.Book;
import com.mikolajczyk.Components.History;
import com.mikolajczyk.Components.Reader;

public class RecordAdding {

    private Book book;
    private Reader reader;
    private History history;

    public RecordAdding(Book book){
        this.book = book;
    }

    public RecordAdding(Reader reader){
        this.reader = reader;
    }

    public RecordAdding(History history){
        this.history = history;
    }

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public History getHistory() {
        return history;
    }

    public void saveRecord(Reader reader){
        LibraryConfiguration.session.save(reader);
    }

    public void saveRecord(Book book){
        LibraryConfiguration.session.save(book);
    }

    public void saveRecord(History history){
        LibraryConfiguration.session.save(history);
    }
}
