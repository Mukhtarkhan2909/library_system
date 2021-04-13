package com.example.library_system.dto;

import com.example.library_system.entity.Book;
import com.example.library_system.entity.Customer;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @NotNull
    Optional<Customer> findById(Long id);
    @NotNull
    List<Customer> findAll();
    @Query(value = "SELECT c.* FROM orders o INNER JOIN customer c ON c.id = o.customer_id WHERE o.book_id = :bookId", nativeQuery = true)
    List<Customer> findCustomerByBookId(@Param("bookId") Long bookId);
}
