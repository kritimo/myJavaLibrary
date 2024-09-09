package com.example.mylibrary.book;

import com.example.mylibrary.Application;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("")
    List<Book> findAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/{title}")
    Book findByTitle(@PathVariable String title){
        Optional<Book> book = bookRepository.findByTitle(title);
        if (book.isEmpty()){
            throw new BookNotFoundException();
        }

        return book.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody Book book){
        bookRepository.create(book);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{title}")
    void update(@RequestBody Book book, @PathVariable String title){
        bookRepository.update(book, title);
    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{title}")
    void delete(@PathVariable String title){
        bookRepository.delete(title);
    }

}
