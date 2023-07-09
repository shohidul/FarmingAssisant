package com.example.fassistant.payload.request;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
 
public class UserUpdateRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    
	@Size(max = 120)
	private String password;
	
	@Size(max = 20)
	private String firstname;
	
	@Size(max = 20)
	private String lastname;
	private String description;
	
	@Size(max = 20)
	private String mobile;
	
	@Column(name = "address")
	private String address;
	
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
    
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
