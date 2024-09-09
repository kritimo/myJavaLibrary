package com.example.mylibrary.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class Book{

        private String title;
        private String author;
        private Genre genre;
        private LocalDate dateFinished;
        private ReadStatus status;
        private String review;
        private Integer rating;

        public Book(String title, String author, Genre genre, LocalDate dateFinished, ReadStatus status, String review, Integer rating) {
                if(title.isEmpty()){
                        throw new IllegalArgumentException("Book must have a title");
                }
                if(author.isEmpty()){
                        throw new IllegalArgumentException("Book must have an author");
                }
                if(0>rating || rating > 10) {
                        throw new IllegalArgumentException("Rating must be between 0 and 10");
                }

                this.title = title;
                this.author = author;
                this.genre = genre;
                this.dateFinished = dateFinished;
                this.status = status;
                this.review = review;
                this.rating = rating;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        // Getter and Setter for author
        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        // Getter and Setter for genre
        public Genre getGenre() {
                return genre;
        }

        public void setGenre(Genre genre) {
                this.genre = genre;
        }

        // Getter and Setter for dateFinished
        public LocalDate getDateFinished() {
                return dateFinished;
        }

        public void setDateFinished(LocalDate dateFinished) {
                this.dateFinished = dateFinished;
        }

        // Getter and Setter for status
        public ReadStatus getStatus() {
                return status;
        }

        public void setStatus(ReadStatus status) {
                this.status = status;
        }

        // Getter and Setter for review
        public String getReview() {
                return review;
        }

        public void setReview(String review) {
                this.review = review;
        }

        // Getter and Setter for rating
        public Integer getRating() {
                return rating;
        }

        public void setRating(Integer rating) {
                this.rating = rating;
        }

        @Override
        public String toString() {
                return "Book{" +
                        "title='" + title + '\'' +
                        ", author='" + author + '\'' +
                        ", genre=" + genre +
                        ", dateFinished=" + dateFinished +
                        ", status=" + status +
                        ", review='" + review + '\'' +
                        ", rating=" + rating +
                        '}';
        }


}