package com.suong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suong.dao.StudentDao;
import com.suong.entity.Hocsinh;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;
	@Transactional
	public List<Hocsinh> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Transactional
	public Hocsinh getStudent(int id) {
		return studentDao.getStudent(id);
	}

	@Transactional
	public void addStudent(Hocsinh Student) {
		studentDao.addStudent(Student);
		
	}

	@Transactional
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
		
	}

	@Transactional
	public void updateStudent(Hocsinh Student) {
		studentDao.updateStudent(Student);
	}



}
