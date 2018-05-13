package com.transire.shop.product.controller;


import com.transire.shop.product.exception.ResourceNotFoundException;
import com.transire.shop.product.model.Product;
import com.transire.shop.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    

    @GetMapping("/products")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public Product create(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable(value = "id") Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }

    @PutMapping("/products/{id}")
    public Product update(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Product productDetails) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());

        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
    	Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

    	productRepository.delete(product);

        return ResponseEntity.ok().build();
    }

}
