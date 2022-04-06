package com.example.smartsneaker.model;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import com.example.smartsneaker.model.audit.DateAudit;


@Entity
@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "name"
        })
})
public class Product extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String price;
    
    @NotBlank
    @Size(max = 15)
    private String quantity;
    
    @NotBlank
    @Size(max = 15)
    private String size;

    @NotBlank
    @Size(max = 100)
    private String color;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "cart_id", nullable = true)
	private Cart cart;

    public Product() {

    }
    

    public Product(Long id, @NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String price,
			@NotBlank @Size(max = 15) String quantity, @NotBlank @Size(max = 15) String size,
			@NotBlank @Size(max = 100) String color, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.size = size;
		this.color = color;
		this.category = category;
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



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getQuantity() {
		return quantity;
	}



	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}



	public String getSize() {
		return size;
	}



	public void setSize(String size) {
		this.size = size;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}

    
}
