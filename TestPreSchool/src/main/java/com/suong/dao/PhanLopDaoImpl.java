package com.suong.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suong.entity.Class1;
import com.suong.entity.Hocsinh;
import com.suong.entity.Phanlop;
@Repository
public class PhanLopDaoImpl implements PhanLopDao{
	@Autowired
	private SessionFactory session;
	@SuppressWarnings("unchecked")
	public List<Phanlop> getAllPhanLop() {
		
		return session.getCurrentSession().createQuery("from Phanlop").list();
	}

	@Override
	public Phanlop getPhanLop(int id) {
		return session.getCurrentSession().load(Phanlop.class, id);
	}

	@Override
	public void addPhanLop(Phanlop phanlop) {
		session.getCurrentSession().save(phanlop);
	}

	@Override
	public void deletePhanLop(int id) {
		session.getCurrentSession().delete(getPhanLop(id));
		
	}

	@Override
	public void updatePhanLop(Phanlop phanlop) {
		session.getCurrentSession().update(phanlop);
		
	}

	@SuppressWarnings("unchecked")
	public List<Hocsinh> getAllStudent() {
		return session.getCurrentSession().createQuery("from Hocsinh").list();
	}

	@SuppressWarnings("unchecked")
	public List<Class1> getAllClass() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Class1").list();
	}

}
