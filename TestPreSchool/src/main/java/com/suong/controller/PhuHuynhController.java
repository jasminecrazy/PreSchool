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

import com.suong.entity.Phuhuynh;
import com.suong.service.PhuHuynhService;

@RestController
public class PhuHuynhController {
	@Autowired
private PhuHuynhService phuhuynhService;
	@RequestMapping(value = "admin/api/parent",method=RequestMethod.GET)
	public ResponseEntity<List<Phuhuynh>>getAllTeacher()
	{
		return new ResponseEntity<List<Phuhuynh>>(phuhuynhService.getAllPhuhuynh(),HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/parent/{id}",method=RequestMethod.GET)
	public ResponseEntity<Phuhuynh>getParent(@PathVariable int id)
	{
		Phuhuynh nhanvien;
		try {
			nhanvien = phuhuynhService.getPhuhuynh(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(nhanvien,HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/parent",method=RequestMethod.POST)
	public ResponseEntity<Void>addParent(@RequestBody Phuhuynh phuhuynh)
	{
		try {
			phuhuynhService.addPhuhuynh(phuhuynh);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping(value = "admin/api/parent",method=RequestMethod.PUT)
	public ResponseEntity<Void>updateEmployee(@RequestBody Phuhuynh phuhuynh)
	{
		try {
			phuhuynhService.updatePhuhuynh(phuhuynh);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "admin/api/parent/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteParent(@PathVariable int id) {
		try {
			phuhuynhService.deletePhuhuynh(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
