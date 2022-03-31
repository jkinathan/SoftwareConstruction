package com.example.smartsneaker.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.smartsneaker.model.Category;
import com.example.smartsneaker.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
//	Page<Category> findById(Long id, Pageable pageable);
//	
	Optional<Category> findByName(String name);

    List<Category> findByIdIn(List<Long> categoryIds);

    Boolean existsByName(String name);

	Category save(Category category);
}
