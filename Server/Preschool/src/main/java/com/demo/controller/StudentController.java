package com.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.entity.Class1;
import com.demo.entity.Student;
import com.demo.service.StudentService;
 
@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	Student studentObj = new Student();

	@RequestMapping(value = "admin/api/Student",
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		headers.add("Access-Control-Max-Age", "3600");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
		
		return new ResponseEntity<List<Student>>(service.getAllStudents(), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "admin/api/Student/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		headers.add("Access-Control-Max-Age", "3600");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
		Student Student;
		try {
			Student = service.getStudent(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(Student,headers, HttpStatus.OK);
	}

	

	@RequestMapping(value = "admin/api/Student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
			service.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "admin/api/Student", method = RequestMethod.POST)
	public ResponseEntity<Void> addStudent(@RequestBody Student student) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		headers.add("Access-Control-Max-Age", "3600");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
		try {
			
			service.addStudent(student);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(headers,HttpStatus.CREATED);
	}
	@RequestMapping(value = "admin/api/Student", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateStudent(@RequestBody Student student) {
		try {
			service.updateStudent(student);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "admin/api/StudentClass", method = RequestMethod.GET)
	public ResponseEntity<List<Class1>> getAllSchool() {
		return new ResponseEntity<>(service.getAllClasses(), HttpStatus.OK);
	}
	
	

	

	
}
