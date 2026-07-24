package com.aba02.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.aba02.model.Product;

@Service
public class ProductService {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1L, "Laptop", true, 999.99));
        products.add(new Product(2L, "Mouse", true, 29.99));
        products.add(new Product(3L, "Keyboard", true, 79.99));
        products.add(new Product(4L, "Monitor", true, 299.99));
        products.add(new Product(5L, "Headphones", true, 149.99));
        products.add(new Product(6L, "Webcam", true, 89.99));
        products.add(new Product(7L, "Desk Lamp", false, 39.99));
        products.add(new Product(8L, "USB Cable", true, 9.99));
        products.add(new Product(9L, "HDMI Cable", true, 14.99));
        products.add(new Product(10L, "Power Bank", true, 49.99));
        products.add(new Product(11L, "Phone Stand", true, 19.99));
        products.add(new Product(12L, "Screen Protector", true, 12.99));
        products.add(new Product(13L, "Case Phone", true, 24.99));
        products.add(new Product(14L, "Charging Dock", true, 59.99));
        products.add(new Product(15L, "SSD 1TB", true, 129.99));
        products.add(new Product(16L, "RAM 16GB", true, 89.99));
        products.add(new Product(17L, "Motherboard", false, 199.99));
        products.add(new Product(18L, "CPU Cooler", true, 49.99));
        products.add(new Product(19L, "Power Supply", true, 119.99));
        products.add(new Product(20L, "Graphics Card", true, 599.99));
        products.add(new Product(21L, "Wireless Mouse", true, 34.99));
        products.add(new Product(22L, "Mechanical Keyboard", true, 129.99));
        products.add(new Product(23L, "Gaming Chair", true, 299.99));
        products.add(new Product(24L, "Desk Pad", true, 29.99));
        products.add(new Product(25L, "USB Hub", true, 39.99));
        products.add(new Product(26L, "Card Reader", true, 19.99));
        products.add(new Product(27L, "External HDD", true, 79.99));
        products.add(new Product(28L, "Network Cable", true, 11.99));
        products.add(new Product(29L, "WiFi Router", true, 89.99));
        products.add(new Product(30L, "Bluetooth Speaker", true, 69.99));
        products.add(new Product(31L, "Microphone", true, 99.99));
        products.add(new Product(32L, "Microphone Stand", true, 29.99));
        products.add(new Product(33L, "Pop Filter", true, 19.99));
        products.add(new Product(34L, "XLR Cable", true, 14.99));
        products.add(new Product(35L, "Audio Interface", false, 199.99));
        products.add(new Product(36L, "Studio Monitor", true, 249.99));
        products.add(new Product(37L, "Instrument Cable", true, 9.99));
        products.add(new Product(38L, "Adapter USB-C", true, 19.99));
        products.add(new Product(39L, "Laptop Stand", true, 44.99));
        products.add(new Product(40L, "Cooling Pad", true, 34.99));

        return products;
    }

}
