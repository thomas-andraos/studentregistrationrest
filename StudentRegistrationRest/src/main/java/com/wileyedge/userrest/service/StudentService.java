package com.wileyedge.userrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wileyedge.userrest.dao.IDao;
import com.wileyedge.userrest.model.Student;

@Service
public class StudentService implements IService {

	@Autowired
	@Qualifier(value = "jparepos")
	private IDao dao;
	
	@Override
	public Student save(Student stu) {
		System.out.println("Inside save() of StudentService");
		Student s = dao.save(stu);
		return s;
	}

	@Override
	public List<Student> retriveAllStudents() {
		System.out.println("Inside retrieveAllUsers() of StudentService");
		List<Student> students = dao.findAll();
		return students;
	}

	@Override
	public Student retriveOne(int id) {
		System.out.println("Inside retriveOne() of StudentService");
		Optional<Student> opt = dao.findById(id);
		Student stu;
		if(opt.isPresent()) {
			stu = opt.get();
			return stu;
		} 
		return null;
	}

	@Override
	public void deleteOneUser(int id) {
		System.out.println("Inside deleteOneUser of StudentService");
		dao.deleteById(id);
		
	}

	@Override
	public List<Student> findByName(String name) {
		System.out.println("Inside findByName(String name) of StudentService");
		return dao.findByName(name);
	}

}
