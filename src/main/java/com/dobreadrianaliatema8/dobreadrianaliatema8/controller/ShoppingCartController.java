package com.dobreadrianaliatema8.dobreadrianaliatema8.controller;

import com.dobreadrianaliatema8.dobreadrianaliatema8.model.ShoppingCart;
import com.dobreadrianaliatema8.dobreadrianaliatema8.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("shoppingCart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @GetMapping("/getAll")
    public List<ShoppingCart> getAllShoppingCarts(){
        return shoppingCartService.getAllShoppingCarts();
    }

    @PostMapping("/createShoppingCart")
    public ShoppingCart createShoppingCart(){
        return shoppingCartService.createShoppinhCart();
    }

    @PostMapping("/addProduct/{shoppingCartId}/{productId}")
    public void addProduct(@PathVariable Integer shoppingCartId, @PathVariable Integer productId){
        shoppingCartService.addProduct(shoppingCartId,productId);
    }

    @DeleteMapping("/removeProduct/{shoppingCartId}/{productId}")
    public void removeProduct(@PathVariable Integer shoppingCartId, @PathVariable Integer productId){
        shoppingCartService.removeProduct(shoppingCartId,productId);
    }

    @GetMapping("/totalPrice/{shoppingCartId}")
    public Integer getTotalPrice(@PathVariable Integer shoppingCartId){
        return shoppingCartService.totalPrice(shoppingCartId);
    }
}
