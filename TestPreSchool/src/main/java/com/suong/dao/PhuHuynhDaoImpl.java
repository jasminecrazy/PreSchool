package com.suong.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suong.entity.Cbyt;
import com.suong.entity.Employee;
import com.suong.entity.Hocsinh;
import com.suong.entity.Phuhuynh;
@Repository
public class PhuHuynhDaoImpl implements PhuHuynhDao{
	@Autowired
	private SessionFactory session;
	@SuppressWarnings("unchecked")
	public List<Phuhuynh> getAllPhuhuynh() {
		return session.getCurrentSession().createQuery("from Phuhuynh").list();
	}

	@Override
	public Phuhuynh getPhuhuynh(int id) {
	
		return  session.getCurrentSession().load(Phuhuynh.class, id);
	}

	@Override
	public void addPhuhuynh(Phuhuynh phuhuynh) {
		session.getCurrentSession().save(phuhuynh);
		
	}

	@Override
	public void deletePhuhuynh(int id) {
		session.getCurrentSession().delete(getPhuhuynh(id));
		
	}

	@Override
	public void updatePhuhuynh(Phuhuynh phuhuynh) {
		session.getCurrentSession().update(phuhuynh);
		
	}

	
	
	
	
}
