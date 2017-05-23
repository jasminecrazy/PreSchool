package com.demo.dao;

import java.util.List;

import com.demo.entity.Class1;
import com.demo.entity.Student;

public interface StudentDao {
	public List<Student> getAllStudents();

	public Student getStudent(int id);

	public void addStudent(Student Student);

	public void deleteStudent(int id);

	public void updateStudent(Student Student);

	public List<Class1> getAllClasses();
	


}
