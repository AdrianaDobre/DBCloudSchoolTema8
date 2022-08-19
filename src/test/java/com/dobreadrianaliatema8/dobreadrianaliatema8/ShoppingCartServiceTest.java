package com.dobreadrianaliatema8.dobreadrianaliatema8;

import com.dobreadrianaliatema8.dobreadrianaliatema8.model.ShoppingCart;
import com.dobreadrianaliatema8.dobreadrianaliatema8.repository.ShoppingCartRepository;
import com.dobreadrianaliatema8.dobreadrianaliatema8.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {
    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @Test
    public void it_should_save_shopping_cart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        when(shoppingCartRepository.save(any(ShoppingCart.class))).thenReturn(new ShoppingCart());
        ShoppingCart shoppingCartCreated = shoppingCartService.createShoppinhCart();
        assertThat(shoppingCartCreated.getId()).isSameAs(shoppingCart.getId());
    }

    @Test
    public void it_should_get_all_shoping_carts(){
        ShoppingCart shoppingCart = new ShoppingCart();
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        shoppingCarts.add(shoppingCart);
        when(shoppingCartRepository.findAll()).thenReturn(shoppingCarts);
        List<ShoppingCart> createdShoppingCarts = shoppingCartService.getAllShoppingCarts();
        assertThat(createdShoppingCarts.size()).isSameAs(shoppingCarts.size()).isGreaterThan(0);
    }
}
