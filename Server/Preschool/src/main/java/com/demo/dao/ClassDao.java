package com.demo.dao;

import java.util.List;

import com.demo.entity.Class1;
import com.demo.entity.Student;

public interface ClassDao {
	public List<Class1> getAllClasses();

	public Class1 getClass(int id);

	public void addClass(Class1 Class1);

	public void deleteClass(int id);

	public void updateClass(Class1 Class1);
}
