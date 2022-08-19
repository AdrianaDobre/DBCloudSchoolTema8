package com.dobreadrianaliatema8.dobreadrianaliatema8.controller;

import com.dobreadrianaliatema8.dobreadrianaliatema8.model.Product;
import com.dobreadrianaliatema8.dobreadrianaliatema8.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    //varianta 2 pentru get produse care nu sunt sterse
    @GetMapping("/allWithoutDeleted")
    public List<Product> getAllProductsAndDeleted(){
        return productService.getAllProductsWithoutDeleted();
    }

    @GetMapping("/allWithout")
    public List<Product> getWithoutDeleted(){
        return productService.getWithoutDeleted();
    }

    @PutMapping("/updateStock/id/{id}/stock")
    public void updateStock(@PathVariable Integer id, @RequestParam Integer stock){
        productService.updateStock(id, stock);
    }

    @PutMapping("/increment/{id}")
    public void incrementStock(@PathVariable Integer id){
        productService.incrementStock(id);
    }

    @PutMapping("/decrement/{id}")
    public void decrementStock(@PathVariable Integer id){
        productService.decrementStock(id);
    }
}
