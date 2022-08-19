package com.dobreadrianaliatema8.dobreadrianaliatema8;

import com.dobreadrianaliatema8.dobreadrianaliatema8.controller.ProductController;
import com.dobreadrianaliatema8.dobreadrianaliatema8.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @MockBean
    ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_create_product() throws Exception{
        String request = "{ \"name\" : \"Aragaz\", \"code\" : \"12345\", \"category\" : \"ELB\", \"stock\" : \"20\",\"price\" : \"555\"}";

        mockMvc.perform(post("/product/addProduct")
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    public void it_should_get_all_products() throws Exception{
        mockMvc.perform(get("/product/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void it_should_update_stock() throws Exception{
        mockMvc.perform(put("/product/updateStock/id/{id}/stock" + "?stock=50",1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
