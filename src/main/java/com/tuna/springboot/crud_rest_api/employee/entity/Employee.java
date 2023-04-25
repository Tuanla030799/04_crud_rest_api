package com.tuna.springboot.crud_rest_api.employee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tuna.springboot.crud_rest_api.book.entity.Book;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "active")
	private int active;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JsonIgnore
	@JoinColumn(name = "employee_id")
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public Employee() {
	}
	
	public Employee(String firstName, String lastName, String email, String password, int active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.active = active;
	}
	
	public int getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getActive() {
		return active;
	}
	
	public void setActive(int active) {
		this.active = active;
	}
	
	public void setId(int id) {
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Employee{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", email='" + email + '\'' +
			", password='" + password + '\'' +
			", active=" + active +
			'}';
	}
}
