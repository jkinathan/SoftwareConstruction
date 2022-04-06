package com.example.smartsneaker;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import com.example.smartsneaker.model.Category;
import com.example.smartsneaker.repository.CategoryRepository;

@DataJpaTest
public class JPAUnitTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	CategoryRepository repository;
	
	@Test
	public void find_no_categories_if_repo_is_empty() {
		Iterable<Category> cats = repository.findAll();

		assertThat(cats).isEmpty();
	}

	@Test
	public void should_store_a_category() {
		Category category = repository.save(new Category((long) 110, "Benzos"));
		assertThat(category).hasFieldOrPropertyWithValue("name", "Benzos");
		assertThat(category).hasFieldOrPropertyWithValue("id", 110);
	}
	 
	@Test
	public void should_find_all_categories() {
		Category cat1 = new Category((long) 102, "Nike");
	    entityManager.persist(cat1);
	    Category cat2 = new Category((long) 103, "New Balance");
	    entityManager.persist(cat2);
	    Category cat3 = new Category((long) 104, "ASICS");
	    entityManager.persist(cat3);
	   
	    Iterable<Category> categories = repository.findAll();
	    assertThat(categories).hasSize(3).contains(cat1, cat2, cat3);
	 }
}
