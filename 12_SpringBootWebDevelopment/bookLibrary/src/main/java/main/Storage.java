package main;

import response.Book;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Book> books;

    public int addBook(Book book){
        int id = books.size();
        books.add(book);

    }
}
