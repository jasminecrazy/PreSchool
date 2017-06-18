package com.suong.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suong.entity.Class1;

@Repository
public class ClassDaoImpl implements ClassDao{

	@Autowired
	private SessionFactory sesion;
	@SuppressWarnings("unchecked")
	public List<Class1> getAllClass() {
		return sesion.getCurrentSession().createQuery("from Class1").list();
	}
	public Class1 getIClass(int id) {
		return sesion.getCurrentSession().load(Class1.class, id);
	}
	public void addIClass(Class1 iclass) {
		sesion.getCurrentSession().save(iclass);
		
	}
	public void deleteIClass(int id) {
		sesion.getCurrentSession().delete(getIClass(id));
		
	}
	public void updateIClass(Class1 iclass) {
		sesion.getCurrentSession().update(iclass);
	}

}
