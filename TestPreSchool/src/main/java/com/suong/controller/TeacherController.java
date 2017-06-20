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
import com.suong.entity.Giaovien;
import com.suong.service.TeacherService;

@RestController
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@RequestMapping(value = "admin/api/teacher",method=RequestMethod.GET)
	public ResponseEntity<List<Giaovien>>getAllTeacher()
	{
		return new ResponseEntity<List<Giaovien>>(teacherService.getAllTeacher(),HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/teacher/{id}",method=RequestMethod.GET)
	public ResponseEntity<Giaovien>getTeacher(@PathVariable int id)
	{
		Giaovien giaovien;
		try {
			giaovien = teacherService.getTeacher(id);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(giaovien,HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/teacher",method=RequestMethod.POST)
	public ResponseEntity<Void>addTeacher(@RequestBody Giaovien giaovien)
	{
		try {
			teacherService.addTeacher(giaovien);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping(value = "admin/api/teacher",method=RequestMethod.PUT)
	public ResponseEntity<Void>updateTeacher(@RequestBody Giaovien giaovien)
	{
		try {
			teacherService.updateTeacher(giaovien);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "admin/api/teacher/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEntranceExam(@PathVariable int id) {
		try {
			teacherService.deleteTeacher(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
