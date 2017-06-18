package com.suong.service;

import java.util.List;

import com.suong.entity.Class1;

public interface ClassService {
	public List<Class1> getAllClass();

	public Class1 getIClass(int id);

	public void addIClass(Class1 iclass);

	public void deleteIClass(int id);

	public void updateIClass(Class1 iclass);
}
