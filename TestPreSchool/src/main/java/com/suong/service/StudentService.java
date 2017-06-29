package com.suong.service;

import java.util.List;

import com.suong.entity.*;

public interface StudentService {
	public List<Hocsinh> getAllStudents();

	public Hocsinh getStudent(int id);

	public Integer addStudent(Hocsinh student);

	public void deleteStudent(int id);

	public void updateStudent(Hocsinh Student);
	public List<Iclass>getAllClass();

	public List<Hocsinh>getStudentByClassId(int classId);
	


}
