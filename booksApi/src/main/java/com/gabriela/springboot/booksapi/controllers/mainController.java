package com.gabriela.springboot.booksapi.controllers;


import com.gabriela.springboot.booksapi.BookDTO;
import com.gabriela.springboot.booksapi.models.Book;

import com.gabriela.springboot.booksapi.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class mainController {
    private final BookService bookService;

    public mainController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }

    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestBody BookDTO bookDTO) {
        Book book = new Book(bookDTO.getTitle(), bookDTO.getDescription(),
                bookDTO.getLanguage(), bookDTO.getNumberOfPages());
        return bookService.createBook(book);
    }

    @RequestMapping("/api/books/{id}")
    public ResponseEntity<Book> show(@PathVariable("id") Long id) {
        return bookService.findBook(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Book> update(@PathVariable("id") Long id, @RequestBody BookDTO bookDTO) {
        return bookService.findBook(id)
                .map(book -> {
                    book.setTitle(bookDTO.getTitle());
                    book.setDescription(bookDTO.getDescription());
                    book.setLanguage(bookDTO.getLanguage());
                    book.setNumberOfPages(bookDTO.getNumberOfPages());
                    return ResponseEntity.ok(bookService.updateBook(book));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> destroy(@PathVariable("id") Long id) {
        return bookService.findBook(id)
                .map(book -> {
                    bookService.deleteBook(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}