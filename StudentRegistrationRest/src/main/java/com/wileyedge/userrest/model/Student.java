package com.wileyedge.userrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Size(min=3,message="Name must have atleast 3 chars")
	@NotBlank(message = "Name is mandatory")
	@Column(name = "name")
	private String name;
	@Min(value = 10,message="You must be 10 years old to be a student")
	@NotNull(message = "age is mandatory")
	@Column(name = "age")
	private int age;
	@Min(value = 400000000,message="Invalid mobile number")
	@NotNull(message = "Mobile Number is mandatory")
	@Column(name = "mob")
	private int mobile;
	@NotBlank(message = "Address is mandatory")
	@Column(name = "addr")
	private String address;
	
	public Student() {
		
	}

	public Student(String name, int age, int mobile, String address) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
