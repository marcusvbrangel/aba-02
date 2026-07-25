package com.aba02.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.aba02.model.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void testeComFalhaProposital() {
        fail("Este teste falhou de propósito para validação.");
    }

    @Test
    void testGetAllProductsReturnsNotNull() {
        List<Product> products = productService.getAllProducts();
        assertNotNull(products);
    }

    @Test
    void testGetAllProductsReturns40Items() {
        List<Product> products = productService.getAllProducts();
        assertEquals(40, products.size());
    }

    @Test
    void testGetAllProductsContainsActiveAndInactiveProducts() {
        List<Product> products = productService.getAllProducts();
        
        long activeCount = products.stream().filter(Product::isActive).count();
        long inactiveCount = products.stream().filter(p -> !p.isActive()).count();

        assertTrue(activeCount > 0);
        assertTrue(inactiveCount > 0);
        assertEquals(40, activeCount + inactiveCount);
    }

    @Test
    void testGetAllProductsHasCorrectActiveProductCount() {
        List<Product> products = productService.getAllProducts();
        long activeCount = products.stream().filter(Product::isActive).count();
        assertEquals(37, activeCount);
    }

    @Test
    void testGetAllProductsHasCorrectInactiveProductCount() {
        List<Product> products = productService.getAllProducts();
        long inactiveCount = products.stream().filter(p -> !p.isActive()).count();
        assertEquals(3, inactiveCount);
    }

    @Test
    void testGetAllProductsContainsExpectedProductNames() {
        List<Product> products = productService.getAllProducts();
        
        boolean hasLaptop = products.stream().anyMatch(p -> "Laptop".equals(p.getName()));
        boolean hasMouse = products.stream().anyMatch(p -> "Mouse".equals(p.getName()));
        boolean hasKeyboard = products.stream().anyMatch(p -> "Keyboard".equals(p.getName()));

        assertTrue(hasLaptop);
        assertTrue(hasMouse);
        assertTrue(hasKeyboard);
    }

    @Test
    void testGetAllProductsContainsExpectedPrices() {
        List<Product> products = productService.getAllProducts();
        
        Product laptop = products.stream().filter(p -> "Laptop".equals(p.getName())).findFirst().orElse(null);
        assertNotNull(laptop);
        assertEquals(999.99, laptop.getPrice());
    }

    @Test
    void testGetAllProductsIdSequence() {
        List<Product> products = productService.getAllProducts();
        
        for (int i = 0; i < products.size(); i++) {
            assertEquals((long) i + 1, products.get(i).getId());
        }
    }

    @Test
    void testInactiveProductsAreCorrect() {
        List<Product> products = productService.getAllProducts();
        
        Product deskLamp = products.stream().filter(p -> p.getId() == 7L).findFirst().orElse(null);
        Product motherboard = products.stream().filter(p -> p.getId() == 17L).findFirst().orElse(null);
        Product audioInterface = products.stream().filter(p -> p.getId() == 35L).findFirst().orElse(null);

        assertNotNull(deskLamp);
        assertNotNull(motherboard);
        assertNotNull(audioInterface);

        assertFalse(deskLamp.isActive());
        assertFalse(motherboard.isActive());
        assertFalse(audioInterface.isActive());
    }

}
