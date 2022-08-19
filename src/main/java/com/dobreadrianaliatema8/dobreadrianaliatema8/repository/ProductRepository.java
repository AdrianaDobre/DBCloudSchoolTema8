package com.dobreadrianaliatema8.dobreadrianaliatema8.repository;

import com.dobreadrianaliatema8.dobreadrianaliatema8.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.deleted = true WHERE p.id = :id")
    void deleteById(Integer id);

    //varianta 2 pentru get produse care nu sunt sterse
    @Query("SELECT p FROM Product p where p.deleted = false")
    List<Product> getAllProductsWithoutDeleted();

    List<Product> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Product p set p.stock = :newStock WHERE p.id = :id")
    void updateStock(Integer id,Integer newStock);

    @Modifying
    @Transactional
    @Query("UPDATE Product p set p.stock = p.stock + 1 WHERE p.id = :id")
    void incrementStock(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Product p set p.stock = p.stock - 1 WHERE p.id = :id")
    void decrementStock(Integer id);
}
