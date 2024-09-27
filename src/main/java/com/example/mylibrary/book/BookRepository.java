package com.example.mylibrary.book;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.util.Assert;


@Repository
public class BookRepository {

    private static final Logger log = LoggerFactory.getLogger(BookRepository.class);
    private final JdbcClient jdbcClient;

    public BookRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Book> findAll(){
        return jdbcClient.sql("select * from book")
                .query(Book.class)
                .list();
    }

    public Optional<Book> findByTitle(String title){
        return jdbcClient.sql("SELECT title, author, genre, date_finished, status, review, rating FROM Book WHERE title = :title" )
                .param("title", title)
                .query(Book.class)
                .optional();
    }

    public void create(Book book) {
        var updated = jdbcClient.sql("INSERT INTO Book(title, author, genre, date_finished, status, review, rating) values(?,?,?,?,?,?,?)")
                .params(List.of(book.getTitle(),book.getAuthor(),book.getGenre(),book.getDateFinished(),book.getStatus(),book.getReview(), book.getRating().toString()))
                .update();

        Assert.state(updated == 1, "Failed to create book " + book.getTitle());
    }

    public void update(Book book, String title) {
        var updated = jdbcClient.sql("update book set author = ?, genre = ?, date_finished = ?, status = ?, review = ?, rating = ? where title = ?")
                .params(List.of(book.getAuthor(),book.getGenre(),book.getDateFinished(),book.getStatus(),book.getReview(), book.getRating().toString(), title))
                .update();

        Assert.state(updated == 1, "Failed to update book " + title);
    }

    public void delete(String title) {
        var updated = jdbcClient.sql("delete from book where title = :title")
                .param("title", title)
                .update();

        Assert.state(updated == 1, "Failed to delete run " + title);
    }

    public int count() {
        return jdbcClient.sql("select * from book").query().listOfRows().size();
    }

    public void saveAll(List<Book> books) {
        books.stream().forEach(this::create);
    }

    public List<Book> findByAuthor(String author) {
        return jdbcClient.sql("select * from book where author = :author")
                .param("author", author)
                .query(Book.class)
                .list();
    }



}
