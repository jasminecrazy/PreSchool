package com.suong.service;

import java.util.List;

import com.suong.entity.Employee;


public interface EmployeeService {
	public List<Employee> getAllEmployee();

	public Employee getEmployee(int id);

	public void addEmployee(Employee nhanvien);

	public void deleteEmployee(int id);

	public void updateEmployee(Employee nhanvien);
}
