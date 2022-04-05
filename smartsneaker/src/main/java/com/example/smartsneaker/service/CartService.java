package com.example.smartsneaker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smartsneaker.config.security.UserPrincipal;
import com.example.smartsneaker.model.Cart;
import com.example.smartsneaker.model.User;
import com.example.smartsneaker.payload.CartRequest;
import com.example.smartsneaker.payload.CartResponse;
import com.example.smartsneaker.payload.UserSummary;
import com.example.smartsneaker.repository.CartRepository;
import com.example.smartsneaker.repository.UserRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
    private UserRepository userRepository;
	
	
//	Creating or Editing a cart
	public CartRequest createEditCart(CartRequest cartRequest,UserPrincipal currentUser) {
		
		Optional<Cart> existingCart  = cartRequest.getId() != null ? cartRepository.findById(cartRequest.getId()) :
			Optional.empty();
		
		User user = userRepository.getOne(currentUser.getId());

        
		Cart cat = existingCart.isPresent() ? existingCart.get() :  new Cart();
		
        cat.setName(cartRequest.getName());
        cat.setProducts(cartRequest.getProducts());
        cat.setQuantity(cartRequest.getQuantity());
        cat.setTotal(cartRequest.getTotal());
        cat.setUser(user);
        
        return cartRepository.save(cat) != null ? cartRequest : null;
    }
	
	
//	Listing all carts
	public List<CartResponse> getAllCarts(UserPrincipal currentUser) {
		List<CartResponse> cats = new ArrayList<>();
		
		for(Cart cat : cartRepository.findAll()) {
			
			CartResponse response = new CartResponse();
			
			response.setId(cat.getId());
			response.setName(cat.getName());
			response.setProducts(cat.getProducts());
			response.setQuantity(cat.getQuantity());
			response.setTotal(cat.getTotal());
			UserSummary creatorSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
	        
			response.setUser(creatorSummary);
			
			
			cats.add(response);
			
		}
		
		return cats;
	}


	
}
