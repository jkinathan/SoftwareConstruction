package com.example.smartsneaker.payload;

import javax.validation.constraints.*;

public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;
    
    @NotBlank
    @Size(min = 4, max = 10)
    private String telephone;
    
    @NotBlank
    @Size(min = 4, max = 100)
    private String address;
    
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getTelephone() {
		
		return telephone;
	}
	
	public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
	
	public String getAddress() {
		
		return address;
	}
	
	public void setAddress(String address) {
	
		this.address = address;
	}
}
