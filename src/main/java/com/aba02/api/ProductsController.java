package com.aba02.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aba02.model.Product;
import com.aba02.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> activeProducts = productService.getAllProducts().stream()
                .filter(Product::isActive)
                .toList();
        return ResponseEntity.ok().body(activeProducts);
    }

}
