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
import com.example.smartsneaker.payload.CategoryRequest;
import com.example.smartsneaker.payload.CategoryResponse;
import com.example.smartsneaker.repository.CategoryRepository;
import com.example.smartsneaker.service.CategoryService;
import com.example.smartsneaker.service.ProductService;


@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
   	public List<CategoryResponse> getAllProducts() {
        return categoryService.getAllCategories();
    }

	@PostMapping("/category")
	public CategoryRequest createCategory(@Valid @RequestBody CategoryRequest request) {
        return categoryService.createEditCategory(request);
    }
	

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        return categoryRepository.findById(categoryId).map(cat -> {
        	categoryRepository.delete(cat);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("categoryId " + categoryId + " not found", null, categoryId));
    }
}
