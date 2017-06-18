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

import com.suong.entity.Class1;
import com.suong.entity.Hocsinh;
import com.suong.entity.Phanlop;
import com.suong.service.PhanLopService;

@RestController
public class PhanLopController {
	@Autowired
private PhanLopService phanLopService;

	@RequestMapping(value = "admin/api/phanlop", method = RequestMethod.GET)
	public ResponseEntity<List<Phanlop>> getAllPhanLop() {
		return new ResponseEntity<List<Phanlop>>(phanLopService.getAllPhanLop(), HttpStatus.OK);
	}

	@RequestMapping(value = "admin/api/phanlop/{id}", method = RequestMethod.GET)
	public ResponseEntity<Phanlop> getPhanLop(@PathVariable int id) {
		Phanlop phanlop;
		try {
			phanlop = phanLopService.getPhanLop(id);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(phanlop, HttpStatus.OK);
	}

	@RequestMapping(value = "admin/api/phanlop", method = RequestMethod.POST)
	public ResponseEntity<Void> addDonDK(@RequestBody Phanlop phanlop) {
		try {
			phanLopService.addPhanLop(phanlop);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "admin/api/phanlop", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateDonDK(@RequestBody Phanlop phanlop) {
		try {
			phanLopService.updatePhanLop(phanlop);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "admin/api/phanlop/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDonDK(@PathVariable int id) {
		try {
			phanLopService.deletePhanLop(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "admin/api/phanlopHS", method = RequestMethod.GET)
	public ResponseEntity<List<Hocsinh>> getAllParent() {
		return new ResponseEntity<>(phanLopService.getAllStudent(), HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/phanlopcl", method = RequestMethod.GET)
	public ResponseEntity<List<Class1>> getAllClass() {
		return new ResponseEntity<>(phanLopService.getAllClass(), HttpStatus.OK);
	}
	
}
