package com.suong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suong.dao.TeacherDao;
import com.suong.entity.Giaovien;
@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
private TeacherDao teacherDao;
	@Transactional
	public List<Giaovien> getAllTeacher() {
		
		return teacherDao.getAllTeacher();
	}

	@Transactional
	public Giaovien getTeacher(int id) {
		return teacherDao.getTeacher(id);
	}

	@Transactional
	public void addTeacher(Giaovien giaovien) {
		teacherDao.addTeacher(giaovien);
		
	}

	@Transactional
	public void deleteTeacher(int id) {
		teacherDao.deleteTeacher(id);
		
	}

	@Transactional
	public void updateTeacher(Giaovien giaovien) {
		teacherDao.updateTeacher(giaovien);
		
	}

}
