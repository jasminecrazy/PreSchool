package com.suong.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suong.entity.Giaovien;
@Repository
public class TeacherDaoImpl implements TeacherDao{
	@Autowired
	private SessionFactory session;
	@SuppressWarnings("unchecked")
	public List<Giaovien> getAllTeacher() {
		return session.getCurrentSession().createQuery("from Giaovien").list();
	}

	@Override
	public Giaovien getTeacher(int id) {
		return session.getCurrentSession().load(Giaovien.class, id);
	}

	@Override
	public void addTeacher(Giaovien giaovien) {
		session.getCurrentSession().save(giaovien);
		
	}

	@Override
	public void deleteTeacher(int id) {
		session.getCurrentSession().delete(getTeacher(id));
		
	}

	@Override
	public void updateTeacher(Giaovien giaovien) {
		session.getCurrentSession().update(giaovien);
		
	}

}
