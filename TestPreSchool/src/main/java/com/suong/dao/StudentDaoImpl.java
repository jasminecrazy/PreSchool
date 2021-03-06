package com.suong.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suong.entity.Hocsinh;
import com.suong.entity.Iclass;
@Repository
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private SessionFactory session;
	@SuppressWarnings("unchecked")
	public List<Hocsinh> getAllStudents() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Hocsinh").list();
	}
	public Hocsinh getStudent(int id) {
		return session.getCurrentSession().load(Hocsinh.class, id);
	}

	@Override
	public Integer addStudent(Hocsinh student) {
		session.getCurrentSession().save(student);
		return student.getId();
	}
	

	@Override
	public void deleteStudent(int id) {
		session.getCurrentSession().delete(getStudent(id));
		
	}

	@Override
	public void updateStudent(Hocsinh Student) {
		session.getCurrentSession().update(Student);
		
	}
	@SuppressWarnings("unchecked")
	public List<Iclass> getAllClass() {
		
		return session.getCurrentSession().createQuery("from Iclass t where t.quantity <=20").list();
	}
	@SuppressWarnings("unchecked")
	public List<Hocsinh> getStudentByClassId(int classId) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Hocsinh t where t.iclass.id = :id").setInteger("id", classId).list();
	}
	@Override
	public Long Count() {
		// TODO Auto-generated method stub
		return (Long) session.getCurrentSession().createQuery("select count(p.id) from Hocsinh p").uniqueResult();
	}
	
	
}
