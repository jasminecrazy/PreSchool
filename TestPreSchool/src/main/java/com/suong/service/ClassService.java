package com.suong.service;

import java.util.List;

import com.suong.entity.Giaovien;
import com.suong.entity.Iclass;

public interface ClassService {
	public List<Iclass> getAllClass();

	public Iclass getIClass(int id);

	public void addIClass(Iclass iclass);

	public void deleteIClass(int id);

	public void updateIClass(Iclass iclass);
	public List<Giaovien> getAllTeacher();
}
