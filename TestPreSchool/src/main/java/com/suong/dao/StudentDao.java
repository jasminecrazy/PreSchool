package com.suong.dao;

import java.util.List;
import com.suong.entity.*;

public interface StudentDao {
	public List<Hocsinh> getAllStudents();

	public Hocsinh getStudent(int id);

	public void addStudent(Hocsinh Student);

	public void deleteStudent(int id);

	public void updateStudent(Hocsinh Student);
	



}
