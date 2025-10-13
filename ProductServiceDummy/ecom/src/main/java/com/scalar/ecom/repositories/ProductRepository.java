package com.scalar.ecom.repositories;

import com.scalar.ecom.modal.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByTitle(String title);

    @Query("SELECT p FROM Product p WHERE p.title = :title")
    Product findProductsByTitle(@Param("title") String title);

    Page<Product> findByTitleContainsIgnoreCase(String title, Pageable pageable);

}
