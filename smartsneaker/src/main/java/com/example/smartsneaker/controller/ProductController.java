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

import com.example.smartsneaker.config.security.CurrentUser;
import com.example.smartsneaker.config.security.UserPrincipal;
import com.example.smartsneaker.exception.ResourceNotFoundException;
import com.example.smartsneaker.model.Product;
import com.example.smartsneaker.payload.ProductRequest;
import com.example.smartsneaker.payload.ProductResponse;
import com.example.smartsneaker.repository.ProductRepository;
import com.example.smartsneaker.service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
//	@GetMapping("/products")
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
	
//	Another method to get all products using payload
	@GetMapping("/products2")
	public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

	
//	Another method to create a product
	@PostMapping("/createproduct")
    public ProductRequest createProduct(@Valid @RequestBody ProductRequest request) {
        return productService.createEditProduct(request);
    }
	
		
//	Method 2 to create product by passing whole product object
//    @PostMapping("/products")
//    public Product createProduct(@Valid @RequestBody Product product) {
//        return productRepository.save(product);
//    }
    
//    Getting specific product by id
    @GetMapping("/{productId}")
    public ProductResponse getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }
    
    
// 	Updating products
    
    @PutMapping("/products/")
    public ProductRequest updateProduct(@Valid @RequestBody ProductRequest productRequest) {
    	
    	return productService.createEditProduct(productRequest);
    }

//    Deleting using Service and payloads 
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
    	return productService.deleteProduct(productId);
    }

//    @DeleteMapping("/products/{productId}")
//    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
//    	
//        return productRepository.findById(productId).map(prod -> {
//        	
//            productRepository.delete(prod);
//            
//            return ResponseEntity.ok().build();
//            
//        }).orElseThrow(() -> new ResourceNotFoundException("ProductId " + productId + " not found", null, productId));
//    }
}
