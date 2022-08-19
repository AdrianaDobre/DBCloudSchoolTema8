package com.dobreadrianaliatema8.dobreadrianaliatema8.service;

import com.dobreadrianaliatema8.dobreadrianaliatema8.model.Product;
import com.dobreadrianaliatema8.dobreadrianaliatema8.model.ShoppingCart;
import com.dobreadrianaliatema8.dobreadrianaliatema8.repository.ProductRepository;
import com.dobreadrianaliatema8.dobreadrianaliatema8.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    public List<ShoppingCart> getAllShoppingCarts(){
        return shoppingCartRepository.findAll();
    }

    public void addProduct(Integer shoppingCartId, Integer productId){
        Optional<Product> product = productRepository.findById(productId);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);
        shoppingCart.get().addProduct(product.get());
        shoppingCartRepository.save(shoppingCart.get());
    }

    public void removeProduct(Integer shoppingCartId, Integer productId){
        Optional<Product> product = productRepository.findById(productId);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);
        shoppingCart.get().removeProduct(product.get());
        shoppingCartRepository.save(shoppingCart.get());
    }

    public Integer totalPrice(Integer shoppingCartId){
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);
        return shoppingCart.get().totalPrice();
    }

    public ShoppingCart createShoppinhCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        return shoppingCartRepository.save(shoppingCart);
    }
}
