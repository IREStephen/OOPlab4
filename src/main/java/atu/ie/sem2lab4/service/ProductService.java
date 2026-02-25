package atu.ie.sem2lab4.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import atu.ie.sem2lab4.model.Product;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private long nextId = 1;

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }
    public List<Product> getAllProducts() {
        return products;
    }
}
