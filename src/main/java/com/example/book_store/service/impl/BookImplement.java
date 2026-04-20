package com.example.book_store.service.impl;

import com.example.book_store.dto.BookDto;
import com.example.book_store.entity.Book;
import com.example.book_store.mapper.BookMapper;
import com.example.book_store.repository.BookRepo;
import com.example.book_store.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookImplement implements BookService {
    BookRepo bookRepo;
    public BookImplement(BookRepo bookRepo)
    {
        this.bookRepo=bookRepo;
    }
    @Override
    public BookDto getBook(String bookId) {
        Book book= bookRepo.findBookId(bookId);
        BookDto bookDto= BookMapper.toDTO(book);
        return bookDto;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books=bookRepo.findAll();
        List<BookDto> bookDtoList=new ArrayList<>();
        for(Book book1:books)
        {
            bookDtoList.add(BookMapper.toDTO(book1));
        }
        return bookDtoList;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book=bookRepo.insert(BookMapper.toBook(bookDto));
        return BookMapper.toDTO(book);
    }

    @Override
    public BookDto updateBookName(BookDto bookDto) {
        bookRepo.updateBookNameByBookId(bookDto.bookId(),bookDto.bookName());
        Book book=bookRepo.findBookId(bookDto.bookId());
        return BookMapper.toDTO(book);
    }
    @Override
    public void deleteBookByBookId(String bookId) {
    bookRepo.deleteById(bookId);
    }
}
