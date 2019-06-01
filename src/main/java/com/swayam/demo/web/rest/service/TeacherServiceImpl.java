package com.swayam.demo.web.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swayam.demo.web.rest.dao.TeacherDao;
import com.swayam.demo.web.rest.model.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	private TeacherDao teacherDao;

	@Autowired
	public TeacherServiceImpl(TeacherDao teacherdao) {
		this.teacherDao = teacherdao;
	}

	@Transactional
	@Override
	public Teacher addTeacher(Teacher teacher) {
		if (teacherDao.checkExistTeacher(teacher.getName())) {
			return teacherDao.updateTeacher(teacher);
		} else
			return teacherDao.addTeacher(teacher);
	}

	@Override
	public List<Teacher> allTeacher() {
		return teacherDao.allTeacher();
	}

	@Transactional
	@Override
	public int deleteTeacher(int id) {
		return teacherDao.deleteTeacher(id);
	}

	@Override
	public Teacher getSingleTeacher(int id) {
		return teacherDao.getSingleTeacher(id);
	}

}
