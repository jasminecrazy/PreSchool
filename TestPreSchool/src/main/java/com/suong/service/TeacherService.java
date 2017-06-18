package com.suong.service;

import java.util.List;

import com.suong.entity.Giaovien;

public interface TeacherService {
	public List<Giaovien> getAllTeacher();

	public Giaovien getTeacher(int id);

	public void addTeacher(Giaovien giaovien);

	public void deleteTeacher(int id);

	public void updateTeacher(Giaovien giaovien);
}
