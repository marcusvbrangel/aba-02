package com.aba02.api;

import com.aba02.model.Product;
import com.aba02.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> activeProducts = productService.getAllProducts().stream()
                .filter(Product::isActive)
                .toList();
        return ResponseEntity.ok().body(activeProducts);
    }

}
