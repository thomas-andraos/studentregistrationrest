package com.wileyedge.userrest.service;

import java.util.List;

import com.wileyedge.userrest.model.Student;

public interface IService {
	public Student save(Student stu);
	public List<Student> retriveAllStudents();
	public Student retriveOne(int id);
	public void deleteOneUser(int id);
	public List<Student> findByName(String name);
}
