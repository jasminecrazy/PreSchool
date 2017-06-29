package com.suong.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suong.entity.Cbyt;
@Repository
public class CBYTDaoImpl implements CBYTDao{
	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cbyt> getAllCbyt() {
		return session.getCurrentSession().createQuery("from Cbyt").list();
	}

	@Override
	public Cbyt getCbyt(int id) {

		return session.getCurrentSession().load(Cbyt.class, id);
	}

	@Override
	public void addCbyt(Cbyt canbo) {
session.getCurrentSession().save(canbo);
		
	}

	@Override
	public void deleteCbyt(int id) {
		session.getCurrentSession().delete(getCbyt(id));
		
	}

	@Override
	public void updateCbyt(Cbyt canbo) {
		session.getCurrentSession().update(canbo);
		
	}

	@Override
	public Long Count() {
		
		return (Long) session.getCurrentSession().createQuery("select count(p.id) from Cbyt p").uniqueResult();
	}
	
	
	
}
