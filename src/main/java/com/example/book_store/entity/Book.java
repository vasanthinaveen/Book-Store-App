package com.example.book_store.entity;


import org.springframework.data.annotation.Id;

public record Book(
        @Id String bookId, String bookName, String bookAuthor, String descriptpion) {


}
