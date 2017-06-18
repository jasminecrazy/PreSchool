package com.suong.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suong.entity.Employee;
import com.suong.entity.Hocsinh;
import com.suong.entity.Nkdkh;
import com.suong.entity.Phuhuynh;
@Repository
public class NhapHocDaoImpl implements NhapHocDao{
	@Autowired
	private SessionFactory session;
	@SuppressWarnings("unchecked")
	@Override
	public List<Nkdkh> getAllDonDK() {
		
		return session.getCurrentSession().createQuery("from Nkdkh").list();
	}

	@Override
	public Nkdkh getDonDk(int id) {
		
		return session.getCurrentSession().load(Nkdkh.class, id);
	}

	@Override
	public void addDonDk(Nkdkh dondk) {
		session.getCurrentSession().save(dondk);
		
	}

	@Override
	public void deleteDonDK(int id) {
		session.getCurrentSession().delete(getDonDk(id));
		
	}

	@Override
	public void updateDonDK(Nkdkh dondk) {
		session.getCurrentSession().update(dondk);
		
	}

	@SuppressWarnings("unchecked")
	public List<Phuhuynh> getAllParent() {
		
		return session.getCurrentSession().createQuery("from Phuhuynh").list();
	}

	@SuppressWarnings("unchecked")
	public List<Hocsinh> getAllStudent() {
		return session.getCurrentSession().createQuery("from Hocsinh").list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		return session.getCurrentSession().createQuery("from Employee").list();
	}

}
