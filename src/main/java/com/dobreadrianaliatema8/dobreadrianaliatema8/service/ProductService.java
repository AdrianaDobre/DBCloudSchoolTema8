package com.dobreadrianaliatema8.dobreadrianaliatema8.service;

import com.dobreadrianaliatema8.dobreadrianaliatema8.model.Category;
import com.dobreadrianaliatema8.dobreadrianaliatema8.model.Product;
import com.dobreadrianaliatema8.dobreadrianaliatema8.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

    public List<Product> getWithoutDeleted(){
        return productRepository.findAll().stream()
                .filter(product -> !product.isDeleted())
                .collect(Collectors.toList());
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //varianta 2 pentru get produse care nu sunt sterse
    public List<Product> getAllProductsWithoutDeleted(){
        return productRepository.getAllProductsWithoutDeleted();
    }

    public void updateStock(Integer id, Integer stock){
        productRepository.updateStock(id,stock);
    }

    public void incrementStock(Integer id){
        productRepository.incrementStock(id);
    }

    public void decrementStock(Integer id){
        productRepository.decrementStock(id);
    }
}
