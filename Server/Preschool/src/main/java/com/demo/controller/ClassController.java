package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Class1;
import com.demo.entity.Student;
import com.demo.service.ClassService;

@RestController
public class ClassController {
	@Autowired
	private ClassService classService;
	@RequestMapping(value = "admin/api/Class",
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	public ResponseEntity<List<Class1>>getAllClasses()
	{
		return new ResponseEntity<List<Class1>>(classService.getAllClasses(),HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/Class/{id}", method = RequestMethod.GET)
	public ResponseEntity<Class1> getClass(@PathVariable int id) {
		Class1 class1;
		try {
			class1 = classService.getClass(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(class1, HttpStatus.OK);
	}

	

	@RequestMapping(value = "admin/api/Class/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteClass(@PathVariable int id) {
			classService.deleteClass(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
