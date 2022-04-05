package com.example.smartsneaker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartsneaker.config.security.CurrentUser;
import com.example.smartsneaker.config.security.UserPrincipal;
import com.example.smartsneaker.payload.CartRequest;
import com.example.smartsneaker.payload.CartResponse;
import com.example.smartsneaker.payload.ProductResponse;
import com.example.smartsneaker.repository.CartRepository;
import com.example.smartsneaker.service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {

	
	@Autowired
    private CartRepository cartRepository;
	
	@Autowired
	private CartService cartService;
	
	
//	Another method to get all carts using payload
	@GetMapping("/carts")
	public List<CartResponse> getAllCarts(@CurrentUser UserPrincipal currentUser) {
        return cartService.getAllCarts(currentUser);
    }

	
//	Another method to create a cart
	@PostMapping("/createcart")
    public CartRequest createCart(@Valid @RequestBody CartRequest request,@CurrentUser UserPrincipal currentUser) {
        return cartService.createEditCart(request,currentUser);
    }
	

}
