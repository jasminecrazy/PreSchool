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
import com.suong.entity.Hocsinh;
import com.suong.entity.Nkdkh;
import com.suong.entity.Phuhuynh;
import com.suong.service.NhapHocService;

@RestController
public class NhapHocController {
	@Autowired
	private NhapHocService nhapHocService;

	@RequestMapping(value = "admin/api/dknh", method = RequestMethod.GET)
	public ResponseEntity<List<Nkdkh>> getAllDonDK() {
		return new ResponseEntity<List<Nkdkh>>(nhapHocService.getAllDonDK(), HttpStatus.OK);
	}

	@RequestMapping(value = "admin/api/dknh/{id}", method = RequestMethod.GET)
	public ResponseEntity<Nkdkh> getDonDK(@PathVariable int id) {
		Nkdkh dondk;
		try {
			dondk = nhapHocService.getDonDk(id);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(dondk, HttpStatus.OK);
	}

	@RequestMapping(value = "admin/api/dknh", method = RequestMethod.POST)
	public ResponseEntity<Void> addDonDK(@RequestBody Nkdkh dondk) {
		try {
			nhapHocService.addDonDk(dondk);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "admin/api/dknh", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateDonDK(@RequestBody Nkdkh dondk) {
		try {
			nhapHocService.updateDonDK(dondk);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "admin/api/dknh/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDonDK(@PathVariable int id) {
		try {
			nhapHocService.deleteDonDK(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "admin/api/dknhPH", method = RequestMethod.GET)
	public ResponseEntity<List<Phuhuynh>> getAllParent() {
		return new ResponseEntity<>(nhapHocService.getAllParent(), HttpStatus.OK);
	}

	@RequestMapping(value = "admin/api/getEmployee", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return new ResponseEntity<>(nhapHocService.getAllEmployee(), HttpStatus.OK);
	}

	@RequestMapping(value = "admin/api/getStudent", method = RequestMethod.GET)
	public ResponseEntity<List<Hocsinh>> getAllStudent() {
		return new ResponseEntity<>(nhapHocService.getAllStudent(), HttpStatus.OK);
	}
}
