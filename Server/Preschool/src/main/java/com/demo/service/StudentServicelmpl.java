package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.StudentDao;
import com.demo.entity.Class1;
import com.demo.entity.Student;
@Service
public class StudentServicelmpl implements StudentService  {

	@Autowired
	private StudentDao studentDao;

	@Transactional
	public List<Student> getAllStudents() {
		
		return studentDao.getAllStudents();
	}

	@Transactional
	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}
	@Transactional
	public void addStudent(Student Student) {
		studentDao.addStudent(Student);
		
	}

	@Transactional
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
		
	}

	@Transactional
	public void updateStudent(Student Student) {
		studentDao.updateStudent(Student);
		
	}

	@Transactional
	public List<Class1> getAllClasses() {
		
		return studentDao.getAllClasses();
	}

}
