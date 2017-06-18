package com.suong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suong.entity.Employee;
import com.suong.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
private EmployeeService employeeService;
	@RequestMapping(value = "admin/api/employee",method=RequestMethod.GET)
	public ResponseEntity<List<Employee>>getAllTeacher()
	{
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/employee/{id}",method=RequestMethod.GET)
	public ResponseEntity<Employee>getEmployee(@PathVariable int id)
	{
		Employee nhanvien;
		try {
			nhanvien = employeeService.getEmployee(id);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(nhanvien,HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/employee",method=RequestMethod.POST)
	public ResponseEntity<Void>addEmployee(@RequestBody Employee nhanvien)
	{
		try {
			employeeService.addEmployee(nhanvien);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping(value = "admin/api/employee",method=RequestMethod.PUT)
	public ResponseEntity<Void>updateEmployee(@RequestBody Employee nhanvien)
	{
		try {
			employeeService.updateEmployee(nhanvien);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "admin/api/employee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		try {
			employeeService.deleteEmployee(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
