package atu.ie.sem2lab4.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import atu.ie.sem2lab4.model.Product;
import atu.ie.sem2lab4.service.ProductService;

@RestController
@RequestMapping("/products")
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
}