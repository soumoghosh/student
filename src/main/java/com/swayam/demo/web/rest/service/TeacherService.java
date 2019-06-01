package com.swayam.demo.web.rest.service;

import java.util.List;

import com.swayam.demo.web.rest.model.Teacher;

public interface TeacherService {
	public Teacher addTeacher(Teacher teacher);

	public List<Teacher> allTeacher();

	public int deleteTeacher(int id);

	public Teacher getSingleTeacher(int id);
}
