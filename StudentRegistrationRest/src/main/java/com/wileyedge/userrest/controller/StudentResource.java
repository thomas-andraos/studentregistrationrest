package com.wileyedge.userrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wileyedge.userrest.exceptions.StudentNotFoundException;
import com.wileyedge.userrest.model.Student;
import com.wileyedge.userrest.service.IService;

@RestController
@CrossOrigin(origins = "*")
public class StudentResource {
	
	@Autowired
	private IService service;
	
	@GetMapping(path = "/students")
	public @ResponseBody List<Student> fetchAllStudents(){	
		System.out.println("Inside fetchAllStudents() of StudentResource");
		List<Student> list = service.retriveAllStudents();
		return list;
	}
	
	@GetMapping(path = "/students/{id}", consumes = "application/json")
	public Student fetchUser(@PathVariable int id) {
		System.out.println("Inside fetchUser() of StudentResource");
		Student s = service.retriveOne(id);
		if(s == null) {
			throw new StudentNotFoundException("user with id: " + id + " not found");
		}
		return s;
	}
	
	@PostMapping(path="/students",consumes = "application/json")
	public Student createStudent(@Validated @RequestBody Student s) {
		System.out.println("Inside createStudent of StudentResource");
		Student stu = service.save(s);
		
		return stu;
	}

	
	@DeleteMapping(path = "/students/{id}")
	public void deleteUser(@PathVariable int id) {
		System.out.println("Inside deleteUser of UserResource");
		service.deleteOneUser(id);
	}
	
	@GetMapping(path = "/students/name/{name}")
	public List<Student> retrieveUsersByName(@PathVariable String name) {
		System.out.println("Inside retrieveUsersByName of UserResource");
		List<Student> students = service.findByName(name);
		System.out.println("Returned Students: " + students);
		
		if(students == null) {
			throw new StudentNotFoundException("no users found with name: '" + name + "'");
		}
		
		return students;
	}
	
	
}
