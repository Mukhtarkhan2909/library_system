package com.example.library_system.dto;

import com.example.library_system.entity.Customer;
import com.example.library_system.entity.Library;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>  {
    @NotNull
    Optional<Library> findById(@NotNull Long id);
    @NotNull
    List<Library> findAll();
    @Query(value = "SELECT l.* FROM Library_Book b INNER JOIN Library l ON l.id = b.library_id WHERE b.book_id = :bookId", nativeQuery = true)
    List<Library> findLibrariesByBookId(@Param("bookId") Long bookId);

}
