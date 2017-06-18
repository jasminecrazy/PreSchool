package com.suong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suong.dao.EmployeeDao;
import com.suong.entity.Employee;
@Service
public class EmployeeServiceImpl implements  EmployeeService{
	@Autowired
	private EmployeeDao employeeDao;
	@Transactional
	public List<Employee> getAllEmployee() {
	
		return employeeDao.getAllEmployee();
	}
	@Transactional
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}

	@Transactional
	public void addEmployee(Employee nhanvien) {
		employeeDao.addEmployee(nhanvien);
		
	}

	@Transactional
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
		
	}

	@Transactional
	public void updateEmployee(Employee nhanvien) {
		employeeDao.updateEmployee(nhanvien);
		
	}

}
