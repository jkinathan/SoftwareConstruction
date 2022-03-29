package com.example.smartsneaker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
//	Creating or Editing a product
	public ProductRequest createEditProduct(ProductRequest productRequest) {
		
		Optional<Product> existingProduct  = productRequest.getId() != null ? productRepository.findById(productRequest.getId()) :
			Optional.empty();
		
		
        
		Product product = existingProduct.isPresent() ? existingProduct.get() :  new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setSize(productRequest.getSize());
        product.setColor(productRequest.getColor());
        product.setCategory(productRequest.getCategory());        
        return productRepository.save(product) != null ? productRequest : null;
    }
	
//	Listing all products
	public List<ProductResponse> getAllProducts() {
		List<ProductResponse> products = new ArrayList<>();
		
		for(Product product : productRepository.findAll()) {
			
			ProductResponse response = new ProductResponse();
			
			response.setId(product.getId());
			response.setName(product.getName());
			response.setPrice(product.getPrice());
			response.setQuantity(product.getQuantity());
			response.setColor(product.getColor());
			response.setSize(product.getSize());
			
			products.add(response);
			
		}
		
		return products;
	}
	
	
//	Getting Product by its id
	public ProductResponse getProductById(Long productId) {
		
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("productId " + productId + " not found", null, productId));
        
        ProductResponse response = new ProductResponse();
        
        response.setId(product.getId());
		response.setName(product.getName());
		response.setPrice(product.getPrice());
		response.setQuantity(product.getQuantity());
		response.setSize(product.getSize());

        return response;
    }
	
	
//	Deleting product
	public String deleteProduct(Long productId) {
		
		Optional<Product> del = productId != null ? productRepository.findById(productId) : Optional.empty();
		if(del.isPresent()) {
			
			try {
				
				productRepository.delete(del.get());
				return "Deleted successfully";
				
			} catch (Exception e) {
				// TODO: handle exception
				return "Not Deleted";
			}
			
		}
		return "Not Deleted";
	}


}
