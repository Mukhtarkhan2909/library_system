package com.example.library_system.service.implementation;

import com.example.library_system.dto.BookRepository;
import com.example.library_system.dto.CustomerRepository;
import com.example.library_system.dto.LibraryRepository;
import com.example.library_system.dto.OrderRepository;
import com.example.library_system.entity.*;
import com.example.library_system.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.saveAndFlush(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public void updateBook(Long bookId, Book book) {
        book.setId(bookId);
        bookRepository.saveAndFlush(book);
    }
    @Override
    public void updateBookPrice(Long bookId, Double price) {
        Book book = bookRepository.findById(bookId).get();
        book.setPrice(price);
        bookRepository.saveAndFlush(book);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public void updateCustomer(Long customerId, Customer customer) {
        customer.setId(customerId);
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void addLibrary(Library library) {
        libraryRepository.saveAndFlush(library);
    }

    @Override
    public void deleteLibrary(Long libraryId) {
        libraryRepository.deleteById(libraryId);
    }

    @Override
    public void updateLibrary(Long libraryId, Library library) {
        library.setId(libraryId);
        libraryRepository.saveAndFlush(library);
    }

    @Override
    public void addOrder(Orders orders) {
        orderRepository.saveAndFlush(orders);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public void updateOrder(Long orderId, Orders orders) {
        orders.setId(orderId);
        orderRepository.saveAndFlush(orders);
    }
}
