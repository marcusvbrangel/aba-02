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
class ProductsTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private products productsController;

    private List<Product> mockProducts;

    @BeforeEach
    void setUp() {
        mockProducts = Arrays.asList(
            new Product(1L, "Laptop", true, 999.99),
            new Product(2L, "Mouse", true, 29.99),
            new Product(3L, "Keyboard", true, 79.99),
            new Product(4L, "Desk Lamp", false, 39.99)
        );
    }

    @Test
    void testGetAllReturnsNotNull() {
        when(productService.getAllProducts()).thenReturn(mockProducts);

        List<Product> result = productsController.getAll();

        assertNotNull(result);
    }

    @Test
    void testGetAllReturnsOnlyActiveProducts() {
        when(productService.getAllProducts()).thenReturn(mockProducts);

        List<Product> result = productsController.getAll();

        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(Product::isActive));
    }

    @Test
    void testGetAllFiltersOutInactiveProducts() {
        when(productService.getAllProducts()).thenReturn(mockProducts);

        List<Product> result = productsController.getAll();

        assertFalse(result.stream().anyMatch(p -> !p.isActive()));
    }

    @Test
    void testGetAllCallsProductService() {
        when(productService.getAllProducts()).thenReturn(mockProducts);

        productsController.getAll();

        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void testGetAllReturnsCorrectProductNames() {
        when(productService.getAllProducts()).thenReturn(mockProducts);

        List<Product> result = productsController.getAll();

        assertTrue(result.stream().anyMatch(p -> "Laptop".equals(p.getName())));
        assertTrue(result.stream().anyMatch(p -> "Mouse".equals(p.getName())));
        assertTrue(result.stream().anyMatch(p -> "Keyboard".equals(p.getName())));
        assertFalse(result.stream().anyMatch(p -> "Desk Lamp".equals(p.getName())));
    }

    @Test
    void testGetAllReturnsCorrectProductIds() {
        when(productService.getAllProducts()).thenReturn(mockProducts);

        List<Product> result = productsController.getAll();

        assertTrue(result.stream().anyMatch(p -> p.getId() == 1L));
        assertTrue(result.stream().anyMatch(p -> p.getId() == 2L));
        assertTrue(result.stream().anyMatch(p -> p.getId() == 3L));
        assertFalse(result.stream().anyMatch(p -> p.getId() == 4L));
    }

    @Test
    void testGetAllWithEmptyList() {
        when(productService.getAllProducts()).thenReturn(Arrays.asList());

        List<Product> result = productsController.getAll();

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void testGetAllWithOnlyActiveProducts() {
        List<Product> activeOnly = Arrays.asList(
            new Product(1L, "Laptop", true, 999.99),
            new Product(2L, "Mouse", true, 29.99)
        );
        when(productService.getAllProducts()).thenReturn(activeOnly);

        List<Product> result = productsController.getAll();

        assertEquals(2, result.size());
        assertEquals(2, result.stream().filter(Product::isActive).count());
    }

    @Test
    void testGetAllWithOnlyInactiveProducts() {
        List<Product> inactiveOnly = Arrays.asList(
            new Product(1L, "Desk Lamp", false, 39.99),
            new Product(2L, "Motherboard", false, 199.99)
        );
        when(productService.getAllProducts()).thenReturn(inactiveOnly);

        List<Product> result = productsController.getAll();

        assertEquals(0, result.size());
    }

}
