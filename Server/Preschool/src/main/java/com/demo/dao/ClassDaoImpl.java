package com.demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.Class1;
@Repository
public class ClassDaoImpl implements ClassDao{
	@Autowired
	private SessionFactory session;
	@SuppressWarnings("unchecked")
	public List<Class1> getAllClasses() {
		return session.getCurrentSession().createQuery("from Class1").list();
	}
	@Override
	public Class1 getClass(int id) {
		return session.getCurrentSession().load(Class1.class,id);
	}

	@Override
	public void addClass(Class1 Class1) {
		session.getCurrentSession().save(Class1);
		
	}

	@Override
	public void deleteClass(int id) {
		session.getCurrentSession().delete(getClass(id));
		
	}

	@Override
	public void updateClass(Class1 Class1) {
		session.getCurrentSession().update(Class1);
		
	}

	

}
