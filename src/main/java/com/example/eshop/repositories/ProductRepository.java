package com.example.eshop.repositories;

import com.example.eshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByTitleAndCity(String title, String city);
    List<Product> findAllByOrderByDateOfCreatedDesc();
    List<Product> findAllByOrderByDateOfCreatedAsc();
}
