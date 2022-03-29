package com.example.smartsneaker.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryRequest {
	
	private Long id;
	
    @NotBlank
    @Size(max = 140)
    private String name;

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
    
    
}
