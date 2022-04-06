package com.example.smartsneaker.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.smartsneaker.payload.ProductRequest;
import com.example.smartsneaker.payload.ProductResponse;
import com.example.smartsneaker.service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
//	Another method to get all products using payload
	@GetMapping("/products")
	public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

	
//	Another method to create or edit a product
	@PostMapping("/createproduct")
    public ProductRequest createProduct(@Valid @RequestBody ProductRequest request) {
        return productService.createEditProduct(request);
    }
	
    
//    Getting specific product by id
    @GetMapping("/product/{productId}")
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
