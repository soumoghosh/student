package com.swayam.demo.web.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swayam.demo.web.rest.model.Student;


public interface StudentService {
	public List<Student> getAllStudent();
	public int deleteStudent(int id);
	public Student createStudent(Student student);
	public int updateStudent(Student student);
	
}
