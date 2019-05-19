package com.swayam.demo.web.rest.service;

import java.util.List;

import com.swayam.demo.web.rest.model.Student;

public interface StudentService {

	List<Student> getAllStudent();

	int deleteStudent(int id);

	Student createStudent(Student student);

	// Student updateStudent(String name);

	Student getStudentById(int id);

	Student getStudentByName(String name);
}
