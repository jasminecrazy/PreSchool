package com.suong.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suong.entity.Hocsinh;
import com.suong.entity.Nktheodoi;

@Repository
public class TheoDoiDaoImpl implements TheoDoiDao{
	@Autowired
private SessionFactory session;
	@SuppressWarnings("unchecked")
	public List<Nktheodoi> getAllTheoDoi() {
		
		return session.getCurrentSession().createQuery("from Nktheodoi").list();
	}
	@Override
	public Nktheodoi getTheoDoi(int id) {
		
		return session.getCurrentSession().load(Nktheodoi.class, id);
	}

	@Override
	public void addTheoDoi(Nktheodoi theodoi) {
		session.getCurrentSession().save(theodoi);
		
	}

	@Override
	public void deleteTheodoi(int id) {
		session.getCurrentSession().delete(getTheoDoi(id));
		
	}

	@Override
	public void updateTheoDoi(Nktheodoi theodoi) {
		session.getCurrentSession().update(theodoi);
		
	}

	@SuppressWarnings("unchecked")
	public List<Hocsinh> getAllStudent() {

		return session.getCurrentSession().createQuery("from Hocsinh").list();
	}
	@SuppressWarnings("unchecked")
	public List<Nktheodoi> getStudentt() {
		
		return session.getCurrentSession().createQuery("from Nktheodoi n group by ngaytheodoi").list();
	}

}
