package com.aba02.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1L, "Laptop", true, 999.99);
    }

    @Test
    void testConstructorWithParameters() {
        assertNotNull(product);
        assertEquals(1L, product.getId());
        assertEquals("Laptop", product.getName());
        assertTrue(product.isActive());
        assertEquals(999.99, product.getPrice());
    }

    @Test
    void testEmptyConstructor() {
        Product emptyProduct = new Product();
        assertNotNull(emptyProduct);
        assertNull(emptyProduct.getId());
        assertNull(emptyProduct.getName());
        assertFalse(emptyProduct.isActive());
        assertNull(emptyProduct.getPrice());
    }

    @Test
    void testSettersAndGetters() {
        Product product = new Product();
        
        product.setId(2L);
        product.setName("Mouse");
        product.setActive(false);
        product.setPrice(29.99);

        assertEquals(2L, product.getId());
        assertEquals("Mouse", product.getName());
        assertFalse(product.isActive());
        assertEquals(29.99, product.getPrice());
    }

    @Test
    void testSetId() {
        product.setId(5L);
        assertEquals(5L, product.getId());
    }

    @Test
    void testSetName() {
        product.setName("Monitor");
        assertEquals("Monitor", product.getName());
    }

    @Test
    void testSetActive() {
        product.setActive(false);
        assertFalse(product.isActive());
        
        product.setActive(true);
        assertTrue(product.isActive());
    }

    @Test
    void testSetPrice() {
        product.setPrice(1299.99);
        assertEquals(1299.99, product.getPrice());
    }

    @Test
    void testIsActive() {
        Product activeProduct = new Product(1L, "Laptop", true, 999.99);
        Product inactiveProduct = new Product(2L, "Monitor", false, 299.99);

        assertTrue(activeProduct.isActive());
        assertFalse(inactiveProduct.isActive());
    }

}
