package com.example.mylibrary.book;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    List<Book> findAll(){
        return books;
    }

    Optional<Book> findByTitle(String title){
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst();
    }

    void create(Book book){
        books.add(book);
    }

    void update(Book book, String title){
        Optional<Book> existingBook = findByTitle(title);
        if(existingBook.isPresent()){
            books.set(books.indexOf(existingBook.get()), book);
        }
    }

    void delete(String title){
        books.removeIf(book -> book.getTitle().equals(title));
    }

    @PostConstruct
    private void init(){
        books.add(new Book("Pride and Prejudice",
                "Jane Austen", Genre.Fiction,
                LocalDate.now(), ReadStatus.WantToRead,
                "Great book", 5));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", Genre.HistoricalFiction,
                LocalDate.now(), ReadStatus.Read,
                "Thought provoking", 4));
        books.add(new Book("MacBeth", "Shakespeare", Genre.HistoricalFiction,
                LocalDate.now(), ReadStatus.Read,
                "Great play", 5));
    }




}
