package com.swayam.demo.web.rest.dao;

import java.util.List;

import com.swayam.demo.web.rest.model.Teacher;

public interface TeacherDao {

	 boolean addTeacher(Teacher teacher);
	
	 boolean deleteTeacher(int id);
	
	 boolean updateTeacher(Teacher teacher);
	
	 List<Teacher> getAllTeacher();
	
	 Teacher getSingleTeacherDeatils(int id);
	 boolean checkExistTeacher(int id);
}
