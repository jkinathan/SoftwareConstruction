package com.example.smartsneaker.controller;
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
import com.example.smartsneaker.model.Category;
import com.example.smartsneaker.model.Product;
import com.example.smartsneaker.repository.CategoryRepository;


@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	@GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


	@PostMapping("/category")
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryRepository.save(category);
    }
	
	@PutMapping("/category/{categoryId}")
    public Category updateCategory(@PathVariable Long categoryId, @Valid @RequestBody Category categoryRequest) {
    	
    	return categoryRepository.findById(categoryId).map(cat -> {
    		cat.setName(cat.getName());
    		cat.setProducts(cat.getProducts());
    		            
            return categoryRepository.save(cat);
            
        }).orElseThrow(() -> new ResourceNotFoundException("categoryId " + categoryId + " not found", null, categoryRequest));
    }


    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        return categoryRepository.findById(categoryId).map(cat -> {
        	categoryRepository.delete(cat);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("categoryId " + categoryId + " not found", null, categoryId));
    }
}
