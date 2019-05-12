package com.swayam.demo.web.rest.dao;

import java.util.List;

import com.swayam.demo.web.rest.model.Student;

public interface StudentDao {

	public List<Student> getAllStudent();

	public int deleteStudent(int id);

	public Student createStudent(Student student);

	public Student updateStudent(Student student);

	public Student getStudentById(int id);
}
