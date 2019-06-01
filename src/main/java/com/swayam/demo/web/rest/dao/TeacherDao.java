package com.swayam.demo.web.rest.dao;

import java.util.List;

import com.swayam.demo.web.rest.model.Teacher;

public interface TeacherDao {

	public Teacher addTeacher(Teacher teacher);

	public List<Teacher> allTeacher();

	public Teacher updateTeacher(Teacher teacher);

	public int deleteTeacher(int id);

	public boolean checkExistTeacher(String name);

	public Teacher getSingleTeacher(int id);
}
