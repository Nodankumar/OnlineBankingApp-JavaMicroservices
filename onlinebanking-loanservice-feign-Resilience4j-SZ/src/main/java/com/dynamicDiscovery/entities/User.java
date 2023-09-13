
package com.dynamicDiscovery.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class User {
	
	
	private Integer id;
	private String firstName;
	private String lastName;

	private String phone;
	
	private String mail;

	private String username;
	
	private String password;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.REMOVE)
	private List<Loan> LoanList;
	

	public User(Integer id, String firstName, String lastName, String phone,String mail, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.mail = mail;
		this.username = username;
		this.password = password;
	}
	
	public User() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}