package com.suong.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suong.entity.Giaovien;
import com.suong.entity.Hocsinh;
import com.suong.entity.Iclass;

@Repository
public class ClassDaoImpl implements ClassDao {

	@Autowired
	private SessionFactory sesion;

	@SuppressWarnings("unchecked")
	public List<Iclass> getAllClass() {
		return sesion.getCurrentSession().createQuery("from Iclass").list();
	}

	public Iclass getIClass(int id) {
		return sesion.getCurrentSession().load(Iclass.class, id);
	}

	public void addIClass(Iclass iclass) {
		sesion.getCurrentSession().save(iclass);

	}

	public void deleteIClass(int id) {
		sesion.getCurrentSession().delete(getIClass(id));

	}

	public void updateIClass(Iclass iclass) {
		sesion.getCurrentSession().update(iclass);
	}

	@SuppressWarnings("unchecked")

	public List<Giaovien> getAllTeacher() {

		return sesion.getCurrentSession().createQuery("from Giaovien").list();
	}

	@SuppressWarnings("unchecked")
	public List<Hocsinh> getStudent(int id) {
	
		return sesion.getCurrentSession()
				.createQuery(
						"select id, studentId, studentName from Hocsinh s where s.iclass.id = :id order by studentId, studentName")
				.setInteger("id", id).list();
	}

}
