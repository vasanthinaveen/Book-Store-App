package com.example.book_store.mapper;

import com.example.book_store.dto.BookDto;
import com.example.book_store.entity.Book;

public class BookMapper {
    public static BookDto toDTO(Book book)
    {
BookDto bookDto=new BookDto(book.bookId(),book.bookName(),book.bookAuthor(),book.descriptpion());
return bookDto;
    }
    public static Book toBook(BookDto bookDto)
    {
        Book book=new Book(bookDto.bookId(),bookDto.bookName(),bookDto.bookAuthor(),bookDto.descriptpion());
        return book;
    }
}
