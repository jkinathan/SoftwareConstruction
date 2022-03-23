package com.example.smartsneaker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smartsneaker.config.security.UserPrincipal;
import com.example.smartsneaker.exception.ResourceNotFoundException;
import com.example.smartsneaker.model.Product;
import com.example.smartsneaker.payload.ProductRequest;
import com.example.smartsneaker.payload.ProductResponse;
import com.example.smartsneaker.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
//	Creating a product
	public Product createProduct(ProductRequest productRequest) {
        
		Product product = new Product();
        product.setname(productRequest.getName());
        product.setprice(productRequest.getPrice());
        product.setquantity(productRequest.getQuantity());
        product.setsize(productRequest.getSize());
        product.setcolor(productRequest.getColor());
        
        return productRepository.save(product);
    }
	
//	Listing all products
	public List<ProductResponse> getAllProducts() {
		List<ProductResponse> products = new ArrayList<>();
		
		for(Product product : productRepository.findAll()) {
			
			ProductResponse response = new ProductResponse();
			
			response.setId(product.getId());
			response.setName(product.getname());
			response.setPrice(product.getprice());
			response.setQuantity(product.getquantity());
			response.setSize(product.getsize());
			
			products.add(response);
			
		}
		
		return products;
	}
	
	
//	Getting Product by its id
	public ProductResponse getProductById(Long productId) {
		
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", productId));
        
        ProductResponse response = new ProductResponse();
        
        response.setId(product.getId());
		response.setName(product.getname());
		response.setPrice(product.getprice());
		response.setQuantity(product.getquantity());
		response.setSize(product.getsize());

        return response;
    }
}
