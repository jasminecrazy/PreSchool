package com.suong.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suong.entity.Hocsinh;
import com.suong.entity.Thutienhoc;

@Repository
public class ThuTienDaoImpl implements ThuTienDao {
	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	public List<Thutienhoc> getAllTien() {
		return session.getCurrentSession().createQuery("from Thutienhoc").list();
	}

	@Override
	public Thutienhoc getTien(int id) {
		return session.getCurrentSession().load(Thutienhoc.class,id);
	}

	@Override
	public void addTien(Thutienhoc tien) {
		session.getCurrentSession().save(tien);

	}

	@Override
	public void deleteTien(int id) {
		session.getCurrentSession().delete(getTien(id));

	}

	@Override
	public void updateTien(Thutienhoc tien) {
		session.getCurrentSession().update(tien);

	}

	@SuppressWarnings("unchecked")
	public List<Hocsinh> getAllStudents() {
		
		return session.getCurrentSession().createQuery("from Hocsinh").list();
	}

	@SuppressWarnings("unchecked")
	public List<Thutienhoc> getStuden(int id) {
		return session.getCurrentSession().createQuery("from Thutienhoc t where t.hocsinh.id = :id").setInteger("id", id).list();
	}

}
