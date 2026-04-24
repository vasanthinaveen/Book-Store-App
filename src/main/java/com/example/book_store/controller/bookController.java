package com.example.book_store.controller;

import com.example.book_store.dto.BookDto;
import com.example.book_store.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-store")
public class bookController {
    BookService bookService;
    public bookController(BookService bookService)
    {
        this.bookService=bookService;
    }
    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeMessage()
    {
        return new ResponseEntity<>("You are Welcome",HttpStatus.OK);
    }
    @GetMapping("/{bookId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BookDto> getBook(@PathVariable String bookId)
    {
        BookDto bookDto=bookService.getBook(bookId);
        return new ResponseEntity<BookDto>(bookDto,HttpStatus.OK);
    }
    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<BookDto>> getAllBooks()
    {
        List<BookDto> booksDtoList=bookService.getAllBooks();

        return new ResponseEntity<>(booksDtoList,HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<BookDto> createBooks(@RequestBody BookDto bookDto)
    {
        BookDto bookDto1=bookService.createBook(bookDto);
        return new ResponseEntity<>(bookDto1,HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<BookDto> updateBooks(@RequestBody BookDto bookDto)
    {
        bookService.updateBookName(bookDto);
        return new ResponseEntity<>(bookDto,HttpStatus.OK);
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBooks(@PathVariable String bookId)
    {
        bookService.deleteBookByBookId(bookId);
        return new ResponseEntity<>("Book Deleted  :"+bookId,HttpStatus.OK);
    }

}

