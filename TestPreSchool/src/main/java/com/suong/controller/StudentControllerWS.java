package com.suong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suong.entity.Giaovien;
import com.suong.entity.Hocsinh;
import com.suong.entity.Iclass;
import com.suong.service.StudentService;

@RestController
public class StudentControllerWS {
	// private static final long serialVersionUID = 1L;
	Hocsinh studentObj = new Hocsinh();

	@Autowired
	private StudentService service;
	

	@RequestMapping(value = "admin/api/Student", method = RequestMethod.GET)
	public ResponseEntity<List<Hocsinh>> getAllStudents() {
		return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
	}

	@RequestMapping(value = "admin/api/Student/{id}", method = RequestMethod.GET)
	public ResponseEntity<Hocsinh> getStudent(@PathVariable int id) {
		Hocsinh Student;
		try {
			Student = service.getStudent(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(Student, HttpStatus.OK);
	}

	@RequestMapping(value = "admin/api/Student", method = RequestMethod.POST)
	public ResponseEntity<Hocsinh> addStudent(@RequestBody Hocsinh student) {
		try {
			service.addStudent(student);
			
			/*Class1 class1 = classService.getIClass(Student.getClass1().getId());
			class1.setQuantity(class1.getQuantity()+1);
			System.out.println(class1.getQuantity());
			classService.updateIClass(class1);*/
			
		
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(student,HttpStatus.CREATED);
	}

	@RequestMapping(value = "admin/api/Student", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateStudent(@RequestBody Hocsinh Student) {
		try {

			Hocsinh student1;
			student1 = service.getStudent(Student.getId());
			service.updateStudent(Student);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "admin/api/Student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
		// try {
		service.deleteStudent(id);
		// } catch (Exception ex) {
		// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		// }
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "admin/api/studentcl", method = RequestMethod.GET)
	public ResponseEntity<List<Iclass>> getAllEntranceExam() {
		return new ResponseEntity<>(service.getAllClass(), HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/liststudent/{classId}", method = RequestMethod.GET)
	public ResponseEntity<List<Hocsinh>>getStudentById(@PathVariable int classId)
	{
		List<Hocsinh> list ;
		try {
			list = service.getStudentByClassId(classId);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	
	}

}
