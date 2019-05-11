package com.swayam.demo.web.rest.service;

import java.util.List;

import com.swayam.demo.web.rest.model.Teacher;

public interface TeacherService {

   public boolean addTeacher(Teacher teacher);
	
	public boolean deleteTeacher(int id);
	
	
	public List<Teacher> getAllTeacher();
	
	public Teacher getSingleTeacherDeatils(int id);
}
