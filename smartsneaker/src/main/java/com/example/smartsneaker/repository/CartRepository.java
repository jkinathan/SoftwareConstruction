package com.example.smartsneaker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartsneaker.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	Optional<Cart> findByName(String name);

    List<Cart> findByIdIn(List<Long> cartIds);
}
