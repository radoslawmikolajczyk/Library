package com.mikolajczyk.Configuration;

import com.mikolajczyk.Components.Book;
import com.mikolajczyk.Components.History;
import com.mikolajczyk.Components.Reader;

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
        LibraryConfiguration.session.delete(history);
    }

    public void deleteBook(){
        LibraryConfiguration.session.delete(book);
    }

    public void deleteReader(){
        LibraryConfiguration.session.delete(reader);
    }

}
