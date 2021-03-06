package com.example.smartsneaker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.smartsneaker.model.Category;
import com.example.smartsneaker.payload.CategoryRequest;
import com.example.smartsneaker.payload.CategoryResponse;
import com.example.smartsneaker.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
//	Creating or Editing a category
	public CategoryRequest createEditCategory(CategoryRequest categoryRequest) {
		
		Optional<Category> existingProduct  = categoryRequest.getId() != null ? categoryRepository.findById(categoryRequest.getId()) :
			Optional.empty();
        
		Category cat = existingProduct.isPresent() ? existingProduct.get() :  new Category();
		
        cat.setName(categoryRequest.getName());
                
        return categoryRepository.save(cat) != null ? categoryRequest : null;
    }
	
//	Listing all products
	public List<CategoryResponse> getAllCategories() {
		List<CategoryResponse> cats = new ArrayList<>();
		
		for(Category cat : categoryRepository.findAll()) {
			
			CategoryResponse response = new CategoryResponse();
			
			response.setId(cat.getId());
			response.setName(cat.getName());
			
			
			cats.add(response);
			
		}
		
		return cats;
	}
	
//	Deleting category
	public String deleteCategory(Long categoryId) {
		
		Optional<Category> del = categoryId != null ? categoryRepository.findById(categoryId) : Optional.empty();
		if(del.isPresent()) {
			
			try {
				
				categoryRepository.delete(del.get());
				return "Category Deleted successfully";
				
			} catch (Exception e) {
				
				return "Not Deleted";
			}
			
		}
		return "Not Deleted";
	}
}
