package com.dobreadrianaliatema8.dobreadrianaliatema8;

import com.dobreadrianaliatema8.dobreadrianaliatema8.model.Category;
import com.dobreadrianaliatema8.dobreadrianaliatema8.model.Product;
import com.dobreadrianaliatema8.dobreadrianaliatema8.repository.ProductRepository;
import com.dobreadrianaliatema8.dobreadrianaliatema8.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void it_should_create_product(){
        Product product = new Product(null,"Aragaz","12345", Category.ELB,20,false,555);
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product productCreated = productService.createProduct(product);
        assertThat(productCreated.getName()).isSameAs(product.getName());
    }

    @Test
    public void it_should_get_all_products(){
        Product product = new Product(null,"Aragaz","12345", Category.ELB,20,false,555);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> createdProductList = productService.getAllProducts();
        assertThat(createdProductList.size()).isSameAs(productList.size()).isGreaterThan(0);
    }

    @Test
    public void it_should_update_stock() {
        Product product = new Product(null,"Aragaz","12345", Category.ELB,50,false,555);
        given(productRepository.findById(product.getId())).willReturn(Optional.of(product));
        productService.updateStock(product.getId(),50);
        Product updatedProduct = productRepository.findById(product.getId()).get();
        assertThat(updatedProduct.getStock()).isSameAs(50);
    }
}
