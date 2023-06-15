package com.wileyedge.userrest.dao;

import java.util.List;
import java.util.Optional;

import com.wileyedge.userrest.model.Student;


public interface IDao {
	public Student save(Student stu);
	
	public List<Student> findAll();
	
	Optional<Student> findById(int id);
	
	public Student deleteById(int id);
	
	public List<Student> findByName(String name);
}
