package atu.ie.sem2lab4.controller;

import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.validation.annotation.Validated;

import atu.ie.sem2lab4.model.Product;
import atu.ie.sem2lab4.service.ProductService;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/search")
        public ResponseEntity<List<Product>> searchByName (
                @RequestParam @NotBlank(message = "The search cannot be empty")
                String name) {
        List<Product> results = productService.getAllProducts().stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());

        return ResponseEntity.ok().body(results);
    }
}