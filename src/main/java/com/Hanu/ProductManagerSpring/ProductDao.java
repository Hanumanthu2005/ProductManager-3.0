package com.Hanu.ProductManagerSpring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    Product findByName(String name);
    List<Product> findByPlace(String place);

    @Query("SELECT p FROM Product p where p.warrenty < ?1")
    List<Product> findOutOfWarrentyProducts(int warrenty);

    @Query("SELECT p FROM Product p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :word, '%')) OR " +
            "LOWER(p.type) LIKE LOWER(CONCAT('%', :word, '%')) OR " +
            "LOWER(p.place) LIKE LOWER(CONCAT('%', :word, '%'))")
    List<Product> findByWord(@Param("word") String word);
}
