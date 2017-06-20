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

import com.suong.entity.Cbyt;
import com.suong.entity.Giaovien;
import com.suong.entity.Hocsinh;
import com.suong.entity.Iclass;
import com.suong.entity.Khamsuckhoe;
import com.suong.service.HealthService;

@RestController
public class HealthController {
	@Autowired
	private HealthService healthService;
	@RequestMapping(value = "admin/api/healthCheck",method=RequestMethod.GET)
	public ResponseEntity<List<Khamsuckhoe>>getAllClasses()
	{
		return new ResponseEntity<List<Khamsuckhoe>>(healthService.getAllHealth(),HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/healthCheck/{id}",method=RequestMethod.GET)
	public ResponseEntity<Khamsuckhoe>getKhamsuckhoe(@PathVariable int id)
	{
		Khamsuckhoe healthCheck;
		try {
			healthCheck = healthService.getHealth(id);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(healthCheck,HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/healthCheck",method=RequestMethod.POST)
	public ResponseEntity<Void>addClass(@RequestBody Khamsuckhoe healthCheck)
	{
		try {
			healthService.addHealth(healthCheck);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping(value = "admin/api/healthCheck",method=RequestMethod.PUT)
	public ResponseEntity<Void>updateHealth(@RequestBody Khamsuckhoe healthCheck)
	{
		try {
			healthService.updateHealth(healthCheck);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "admin/api/healthCheck/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteHealth(@PathVariable int id) {
		try {
			healthService.deleteHealth(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "admin/api/studentHealth", method = RequestMethod.GET)
	public ResponseEntity<List<Hocsinh>> getAllEntranceExam() {
		return new ResponseEntity<>(healthService.getAllStudent(), HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/cbytHealth", method = RequestMethod.GET)
	public ResponseEntity<List<Cbyt>> getAllCBYT() {
		return new ResponseEntity<>(healthService.getAllCBYT(), HttpStatus.OK);
	}
}
