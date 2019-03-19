package com.example.easynotes.controller;

import com.example.easynotes.exception.BookNotFoundException;
import com.example.easynotes.model.Book;
import com.example.easynotes.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllNotes() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public Book createNote(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/books/{id}")
    public Book getNoteById(@PathVariable(value = "id") Long bookId)
            throws BookNotFoundException {
        return bookRepository.findById(bookId).orElseThrow(() -> new
                BookNotFoundException(bookId));
    }

    @PutMapping("/books/{id}")
    public Book updateNote(@PathVariable(value = "id") Long bookId,
                           @RequestBody Book bookDetails) throws BookNotFoundException {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new
                BookNotFoundException(bookId));
        book.setTitle(bookDetails.getTitle());
        book.setEncounters_count(bookDetails.getEncounters_count());
        Book updatedBook = bookRepository.save(book);
        return updatedBook;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId)
        throws BookNotFoundException {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new
                BookNotFoundException(bookId));
        bookRepository.delete(book);
        return ResponseEntity.ok().build();
    }
}
