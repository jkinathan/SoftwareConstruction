package com.example.smartsneaker.controller;

// import java.awt.print.Pageable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartsneaker.exception.ResourceNotFoundException;
import com.example.smartsneaker.model.Product;
import com.example.smartsneaker.repository.ProductRepository;


@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
    private ProductRepository productRepository;
	
	@GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }
    
    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable Long productId, @Valid @RequestBody Product productRequest) {
    	
    	return productRepository.findById(productId).map(prod -> {
            prod.setname(prod.getname());
            prod.setprice(prod.getprice());
            prod.setcolor(prod.getcolor());
            prod.setquantity(prod.getquantity());
            prod.setsize(prod.getsize());
            
            return productRepository.save(prod);
            
        }).orElseThrow(() -> new ResourceNotFoundException("productId " + productId + " not found", null, productRequest));
    }


    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        return productRepository.findById(productId).map(prod -> {
            productRepository.delete(prod);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ProductId " + productId + " not found", null, productId));
    }
}
