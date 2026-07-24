package com.aba02.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aba02.model.Product;
import com.aba02.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class products {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts().stream()
                .filter(Product::isActive)
                .toList();
    }

}
