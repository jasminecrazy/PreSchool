package com.suong.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suong.entity.Employee;
import com.suong.entity.Hocsinh;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		return session.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public Employee getEmployee(int id) {
		return session.getCurrentSession().load(Employee.class, id);
	}

	@Override
	public void addEmployee(Employee nhanvien) {
		session.getCurrentSession().save(nhanvien);
		
	}

	@Override
	public void deleteEmployee(int id) {
		session.getCurrentSession().delete(getEmployee(id));
		
	}

	@Override
	public void updateEmployee(Employee nhanvien) {
		session.getCurrentSession().update(nhanvien);
		
	}
	
	
	
}
