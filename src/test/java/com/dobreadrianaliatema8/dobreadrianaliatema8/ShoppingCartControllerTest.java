package com.dobreadrianaliatema8.dobreadrianaliatema8;

import com.dobreadrianaliatema8.dobreadrianaliatema8.controller.ShoppingCartController;
import com.dobreadrianaliatema8.dobreadrianaliatema8.model.ShoppingCart;
import com.dobreadrianaliatema8.dobreadrianaliatema8.service.ProductService;
import com.dobreadrianaliatema8.dobreadrianaliatema8.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingCartController.class)
public class ShoppingCartControllerTest {
    @MockBean
    ShoppingCartService shoppingCartService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_create_shoppig_cart() throws Exception{
//        String request = "{\"id\" : 1, \"productList\" : null }";
        mockMvc.perform(post("/shoppingCart/createShoppingCart")
//                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    public void it_should_get_all_shopping_carts() throws Exception{
        mockMvc.perform(get("/shoppingCart/getAll"))
                .andExpect(status().isOk());
    }
}
