package com.example.smartsneaker.payload;

// import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
// import java.util.List;

public class ProductRequest {
	
	private Long id;
	
    @NotBlank
    @Size(max = 140)
    private String name;

    @NotBlank
    @Size(max = 140)
    private String price;

    @NotBlank
    @Size(max = 140)
    private String size;

    @NotBlank
    @Size(max = 140)
    private String color;

    @NotBlank
    @Size(max = 140)
    private String quantity;

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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    

}

