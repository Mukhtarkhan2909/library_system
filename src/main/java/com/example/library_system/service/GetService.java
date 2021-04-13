package com.example.library_system.service;

import com.example.library_system.entity.*;

import java.util.List;
import java.util.Optional;

public interface GetService {
    Optional<Book> getBookById(Long id);
    Optional<Customer> getCustomerById(Long id);
    Optional<Library> getLibraryById(Long id);
    Optional<Orders> getOrderById(Long id);

    List<Book> getAllBooks();
    List<Customer> getAllCustomers();
    List<Library> getAllLibraries();
    List<Orders> getAllOrders();

    List<Library> getLibrariesByBookId(Long bookId);
    List<Book> getBooksByCustomerId(Long customerId);
    List<Customer> getCustomersByBookId(Long bookId);
    List<Book> getAvailableBooksByLibraryId(Long libraryId);
    List<Book> getBooksByAuthorAndGenre(String author, String genre);
}
