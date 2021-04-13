package com.example.library_system.service;

import com.example.library_system.entity.*;

public interface PostService {
    void addBook(Book book);
    void deleteBook(Long bookId);
    void updateBook(Long bookId, Book book);
    void updateBookPrice(Long bookId, Double price);

    void addCustomer(Customer customer);
    void deleteCustomer(Long customerId);
    void updateCustomer(Long customerId, Customer customer);

    void addLibrary(Library library);
    void deleteLibrary(Long libraryId);
    void updateLibrary(Long libraryId, Library library);

    void addOrder(Orders orders);
    void deleteOrder(Long orderId);
    void updateOrder(Long orderId, Orders orders);
}
