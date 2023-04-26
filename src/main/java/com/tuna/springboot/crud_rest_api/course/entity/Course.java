package com.tuna.springboot.crud_rest_api.course.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

//	@Column(name = "employee_id")
//	private int employeeId;

	public Course() {};

	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", title='" + title + '\'' +
				'}';
	}
}
