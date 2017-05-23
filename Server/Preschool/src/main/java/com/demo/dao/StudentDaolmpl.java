package com.demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.Class1;
import com.demo.entity.Student;


@Repository
public class StudentDaolmpl implements StudentDao {
	@Autowired
	private SessionFactory session;
	@SuppressWarnings("unchecked")
	
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Student").list();
	}


	public Student getStudent(int id) {
		
		return session.getCurrentSession().load(Student.class, id);
	}

	public void addStudent(Student Student) {
		session.getCurrentSession().save(Student);
		
	}

	public void deleteStudent(int id) {
		session.getCurrentSession().delete(getStudent(id));
	}

	public void updateStudent(Student Student) {
		session.getCurrentSession().update(Student);
		
	}


	@SuppressWarnings("unchecked")
	public List<Class1> getAllClasses() {
		
		return session.getCurrentSession().createQuery("Class1").list();
	}
	
	

}
