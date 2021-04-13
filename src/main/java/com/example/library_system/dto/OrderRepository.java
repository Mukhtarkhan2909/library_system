package com.example.library_system.dto;

import com.example.library_system.entity.Orders;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @NotNull
    Optional<Orders> findById(Long id);
    @NotNull
    List<Orders> findAll();
}
