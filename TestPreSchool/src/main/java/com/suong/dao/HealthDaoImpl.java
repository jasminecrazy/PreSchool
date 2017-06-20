package com.suong.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suong.entity.Cbyt;
import com.suong.entity.Hocsinh;
import com.suong.entity.Khamsuckhoe;

@Repository
public class HealthDaoImpl implements HealthDao{
	@Autowired
	private SessionFactory sesion;
	@SuppressWarnings("unchecked")
	public List<Khamsuckhoe> getAllHealth() {

		return sesion.getCurrentSession().createQuery("from Khamsuckhoe").list();
	}

	public Khamsuckhoe getHealth(int id) {
		// TODO Auto-generated method stub
		return sesion.getCurrentSession().load(Khamsuckhoe.class, id);
	}

	@Override
	public void addHealth(Khamsuckhoe health) {
		sesion.getCurrentSession().save(health);
		
	}

	@Override
	public void deleteHealth(int id) {
		sesion.getCurrentSession().delete(sesion);
		
	}

	@Override
	public void updateHealth(Khamsuckhoe health) {
	sesion.getCurrentSession().update(health);
		
	}

	@SuppressWarnings("unchecked")
	public List<Cbyt> getAllCBYT() {
		
		return sesion.getCurrentSession().createQuery("from Cbyt").list();
	}

	@SuppressWarnings("unchecked")
	public List<Hocsinh> getAllStudent() {
		
		return sesion.getCurrentSession().createQuery("from Hocsinh").list();
	}

}
