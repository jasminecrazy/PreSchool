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

import com.suong.entity.Hocsinh;

import com.suong.entity.Thutienhoc;
import com.suong.service.ThuTienService;

@RestController
public class ThuTienController {
	@Autowired
	private ThuTienService thutienService;

	@RequestMapping(value = "admin/api/thutien", method = RequestMethod.GET)
	public ResponseEntity<List<Thutienhoc>> getAllTien() {
		return new ResponseEntity<List<Thutienhoc>>(thutienService.getAllTien(), HttpStatus.OK);
	}

	@RequestMapping(value = "admin/api/thutien/{id}", method = RequestMethod.GET)
	public ResponseEntity<Thutienhoc> getTien(@PathVariable int id) {
		Thutienhoc thutien;
		try {
			thutien = thutienService.getTien(id);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(thutien, HttpStatus.OK);
	}

	@RequestMapping(value = "admin/api/thutien", method = RequestMethod.POST)
	public ResponseEntity<Void> addTien(@RequestBody Thutienhoc thutien) {
		try {
			thutienService.addTien(thutien);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "admin/api/thutien", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateThuTien(@RequestBody Thutienhoc thutien) {
		try {
			thutienService.updateTien(thutien);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "admin/api/thutien/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteThuTien(@PathVariable int id) {
		try {
			thutienService.deleteTien(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "admin/api/getstudent", method = RequestMethod.GET)
	public ResponseEntity<List<Hocsinh>> getAllStudents() {
		return new ResponseEntity<>(thutienService.getAllStudents(), HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/student_thutien/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Thutienhoc>> getAllStu(@PathVariable int id) {
		return new ResponseEntity<>(thutienService.getStuden(id), HttpStatus.OK);
	}
	

}
