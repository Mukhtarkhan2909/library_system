package com.example.library_system.controller;

import com.example.library_system.entity.Book;
import com.example.library_system.entity.Customer;
import com.example.library_system.service.implementation.PostServiceImpl;
import com.example.library_system.service.implementation.GetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    PostServiceImpl postService;
    @Autowired
    GetServiceImpl getService;

    @GetMapping("")
    public List<Book> getAllBooks() {
        return getService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return getService.getBookById(id).get();
    }

    @GetMapping("/find/")
    public List<Book> getByNameContainingAndAge(@RequestParam String author,
                                                @RequestParam String genre) {
        return getService.getBooksByAuthorAndGenre(author, genre);
    }

    @GetMapping("/library/{id}")
    public List<Book> getAvailableBooksByLibraryId(@PathVariable("id") Long id) {
        return getService.getAvailableBooksByLibraryId(id);
    }

    @GetMapping("/customer/{id}")
    public List<Book> getBooksByCustomerId(@PathVariable("id") Long id) {
        return getService.getBooksByCustomerId(id);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        postService.addBook(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id,
                           @RequestBody Book book) {
        postService.updateBook(id, book);
    }

    @PatchMapping("/{id}")
    public void updateBookPrice(@PathVariable Long id,
                              @RequestParam Double price) {
        postService.updateBookPrice(id, price);
    }
}
