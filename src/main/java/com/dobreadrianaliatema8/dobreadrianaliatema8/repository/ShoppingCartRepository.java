package com.dobreadrianaliatema8.dobreadrianaliatema8.repository;

import com.dobreadrianaliatema8.dobreadrianaliatema8.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    List<ShoppingCart> findAll();
}
