package com.example.library_system.service.implementation;

import com.example.library_system.dto.BookRepository;
import com.example.library_system.dto.CustomerRepository;
import com.example.library_system.dto.LibraryRepository;
import com.example.library_system.dto.OrderRepository;
import com.example.library_system.entity.*;
import com.example.library_system.service.GetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GetServiceImpl implements GetService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Library> getLibraryById(Long id) {
        return libraryRepository.findById(id);
    }

    @Override
    public Optional<Orders> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Library> getLibrariesByBookId(Long bookId) {
        return libraryRepository.findLibrariesByBookId(bookId);
    }

    @Override
    public List<Book> getBooksByCustomerId(Long customerId) {
        return bookRepository.findBooksByCustomerId(customerId);
    }

    @Override
    public List<Customer> getCustomersByBookId(Long bookId) {
        return customerRepository.findCustomerByBookId(bookId);
    }

    @Override
    public List<Book> getAvailableBooksByLibraryId(Long libraryId) {
        return bookRepository.findBooksByLibraryId(libraryId);
    }

    @Override
    public List<Book> getBooksByAuthorAndGenre(String author, String genre) {
        return bookRepository.findAllByAuthorAndGenre(author, genre);
    }
}
