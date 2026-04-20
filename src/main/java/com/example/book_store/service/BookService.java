package com.example.book_store.service;

import com.example.book_store.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    public BookDto getBook(String bookId);
    public List<BookDto> getAllBooks();
    public BookDto createBook(BookDto bookDto);
    public BookDto updateBookName(BookDto bookDto);
    public void deleteBookByBookId(String bookId);
}
