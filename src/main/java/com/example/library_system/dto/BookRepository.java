package com.example.library_system.dto;

import com.example.library_system.entity.Book;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @NotNull
    Optional<Book> findById(Long id);
    @NotNull
    List<Book> findAll();
    List<Book> findAllByAuthorAndGenre(String author, String genre);
    @Query(value = "SELECT b.* FROM Orders o INNER JOIN book b ON o.book_id = b.id WHERE o.customer_id = :customerId", nativeQuery = true)
    List<Book> findBooksByCustomerId(@Param("customerId") Long customerId);
    @Query(value = "SELECT b.* FROM library_book o INNER JOIN book b ON o.book_id = b.id WHERE o.library_id = :libraryId", nativeQuery = true)
    List<Book> findBooksByLibraryId(@Param("libraryId") Long libraryId);
}
