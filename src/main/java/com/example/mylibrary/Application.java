package com.example.mylibrary;

import com.example.mylibrary.book.Book;
import com.example.mylibrary.book.Genre;
import com.example.mylibrary.book.ReadStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Book book = new Book("Pride and Prejudice", "Jane Austen", Genre.Fiction, LocalDate.now(), ReadStatus.WantToRead, "Great book", 5);
			log.info("Book " + book);
		};
	}

}
