package com.swayam.demo.web.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swayam.demo.web.rest.dao.StudentDao;
import com.swayam.demo.web.rest.model.Student;
@Service
public class SudentServiceImpl implements StudentService{
	
	private StudentDao studentdao;
	
	@Autowired
	public SudentServiceImpl(StudentDao studentdao) {

		this.studentdao=studentdao;
	}



	@Override
	public List<Student> getAllStudent() {
		return studentdao.getAllStudent();
	}

	@Override
	public int deleteStudent(int id) {
		return studentdao.deleteStudent(id);
	}

	@Override
	public int createStudent(Student student) {
		return studentdao.createStudent(student);
	}
	@Transactional
	@Override
	public int updateStudent(Student student) {
		return studentdao.updateStudent(student);
	}

	
}
