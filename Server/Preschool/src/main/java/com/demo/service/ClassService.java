package com.demo.service;

import java.util.List;

import com.demo.entity.Class1;

public interface ClassService {
	public List<Class1> getAllClasses();

	public Class1 getClass(int id);

	public void addClass(Class1 Class1);

	public void deleteClass(int id);

	public void updateClass(Class1 Class1);
}
