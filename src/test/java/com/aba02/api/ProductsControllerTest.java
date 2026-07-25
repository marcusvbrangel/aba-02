package com.aba02.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.aba02.model.Product;
import com.aba02.service.ProductService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductsControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductsController productsController;

    private List<Product> mockProducts;

    @BeforeEach
    void setUp() {
        mockProducts = Arrays.asList(
            new Product(1L, "Laptop", true, 999.99),
            new Product(2L, "Mouse", true, 29.99),
            new Product(3L, "Desk Lamp", false, 39.99)
        );
    }

    @Test
    void testGetAllReturnsActiveProducts() {
        when(productService.getAllProducts()).thenReturn(mockProducts);

        var response = productsController.getAll();

        assertNotNull(response);
        assertEquals(2, response.getBody().size());
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testGetAllFiltersInactiveProducts() {
        when(productService.getAllProducts()).thenReturn(mockProducts);

        var response = productsController.getAll();
        List<Product> products = response.getBody();

        assertNotNull(products);
        assertTrue(products.stream().allMatch(Product::isActive));
        assertFalse(products.stream().anyMatch(p -> !p.isActive()));
    }

    @Test
    void testGetAllReturnsOkStatus() {
        when(productService.getAllProducts()).thenReturn(mockProducts);

        var response = productsController.getAll();

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    void testGetAllCallsProductService() {
        when(productService.getAllProducts()).thenReturn(mockProducts);

        productsController.getAll();

        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void testGetAllReturnsCorrectActiveProductNames() {
        when(productService.getAllProducts()).thenReturn(mockProducts);

        var response = productsController.getAll();
        List<Product> products = response.getBody();

        assertNotNull(products);
        assertTrue(products.stream().anyMatch(p -> "Laptop".equals(p.getName())));
        assertTrue(products.stream().anyMatch(p -> "Mouse".equals(p.getName())));
        assertFalse(products.stream().anyMatch(p -> "Desk Lamp".equals(p.getName())));
    }

    @Test
    void testGetAllReturnsCorrectActiveProductPrices() {
        when(productService.getAllProducts()).thenReturn(mockProducts);

        var response = productsController.getAll();
        List<Product> products = response.getBody();

        assertNotNull(products);
        assertTrue(products.stream().anyMatch(p -> p.getPrice() == 999.99));
        assertTrue(products.stream().anyMatch(p -> p.getPrice() == 29.99));
    }

    @Test
    void testGetAllWithEmptyList() {
        when(productService.getAllProducts()).thenReturn(Arrays.asList());

        var response = productsController.getAll();

        assertNotNull(response);
        assertEquals(0, response.getBody().size());
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testGetAllWithOnlyInactiveProducts() {
        List<Product> inactiveProducts = Arrays.asList(
            new Product(1L, "Desk Lamp", false, 39.99),
            new Product(2L, "Motherboard", false, 199.99)
        );
        when(productService.getAllProducts()).thenReturn(inactiveProducts);

        var response = productsController.getAll();

        assertNotNull(response);
        assertEquals(0, response.getBody().size());
    }

}
