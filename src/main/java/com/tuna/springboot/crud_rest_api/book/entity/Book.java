package com.tuna.springboot.crud_rest_api.book.entity;

import com.tuna.springboot.crud_rest_api.employee.entity.Employee;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name = "employee_id")
//	private int employeeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "price")
	private float price;
	
//	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//	@JoinColumn(name = "employee_id")
//	private Employee employee;
	
	public Book() {
	}
	
	public Book(String name, String author, float price, Employee employee) {
		this.name = name;
		this.author = author;
		this.price = price;
//		this.employee = employee;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
	
	@Override
	public String toString() {
		return "Book{" +
			"id=" + id +
			", name='" + name + '\'' +
			", author='" + author + '\'' +
			", price=" + price +
			'}';
	}
}
