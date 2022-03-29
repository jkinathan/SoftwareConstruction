package com.example.smartsneaker.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.smartsneaker.model.audit.DateAudit;

@Entity
@Table(name = "cart", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "name"
        })
})
public class CartProduct extends DateAudit{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
    @Size(max = 40)
    private String name;
	
	@NotBlank
    @Size(max = 15)
    private double quantity;
	
	@NotBlank
	@Size(max = 15)
    private double total;
	
	@OneToMany(mappedBy="cart")
    private Set<Product> products;
	
    @NotNull
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    
	public CartProduct() {
		
	}


	public CartProduct(Long id, @NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) double quantity,
			@NotBlank @Size(max = 15) double total, Set<Product> products, @NotNull User user) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.total = total;
		this.products = products;
		this.user = user;
	}


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


	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	

	
    
    
}
