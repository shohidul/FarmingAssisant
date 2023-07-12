package com.example.fassistant.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
 
public class UserUpdateRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
	@Size(max = 120)
	private String password;
	@Size(max = 20)
	private String name;
	@Size(max = 20)
	private String nid;
	private String tin;
	@Size(max = 20)
	private String phone;
	private String location;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
