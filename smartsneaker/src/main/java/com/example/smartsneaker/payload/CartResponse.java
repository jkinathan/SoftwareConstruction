package com.example.smartsneaker.payload;

import java.util.List;
import com.example.smartsneaker.model.Product;

public class CartResponse {
	
	private Long id;
    private String name;
    private double quantity;
    private double total;
    private UserSummary user;
    private List<Product> products;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double d) {
		this.quantity = d;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public UserSummary getUser() {
		return user;
	}
	public void setUser(UserSummary user) {
		this.user = user;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
    
    
}
