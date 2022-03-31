package com.example.smartsneaker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.smartsneaker.model.Category;
import com.example.smartsneaker.repository.CategoryRepository;

@DataJpaTest
public class JPAUnitTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	CategoryRepository catrepo;
	
	
//  @Test
//  public void should_find_no_categories_if_repository_is_empty() {
//    Iterable categories = catrepo.findAll();
//    assertThat(categories).isEmpty();
//  }
//  @Test
//  public void should_store_a_category() {
//    Category category = catrepo.save(new Category((long) 101, "Adidas"));
//    assertThat(category).hasFieldOrPropertyWithValue("name", "Adidas");
//    assertThat(category).hasFieldOrPropertyWithValue("id", 101);
//  }
  @Test
  public void should_find_all_categories() {
	Category cat1 = new Category((long) 102, "Nike");
    entityManager.persist(cat1);
    Category cat2 = new Category((long) 103, "New Balance");
    entityManager.persist(cat2);
    Category cat3 = new Category((long) 104, "ASICS");
    entityManager.persist(cat3);
    
    Iterable categories = catrepo.findAll();
    assertThat(categories).hasSize(3).contains(cat1, cat2, cat3);
  }
}
