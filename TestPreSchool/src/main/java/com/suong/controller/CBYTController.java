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
import com.suong.service.CBYTService;


@RestController
public class CBYTController {
	@Autowired
private CBYTService canboService;
	@RequestMapping(value = "admin/api/cbyt",method=RequestMethod.GET)
	public ResponseEntity<List<Cbyt>>getAllTeacher()
	{
		return new ResponseEntity<List<Cbyt>>(canboService.getAllCbyt(),HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/cbyt/{id}",method=RequestMethod.GET)
	public ResponseEntity<Cbyt>getEmployee(@PathVariable int id)
	{
		Cbyt cbyt;
		try {
			cbyt = canboService.getCbyt(id);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cbyt,HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/cbyt",method=RequestMethod.POST)
	public ResponseEntity<Void>addCanBo(@RequestBody Cbyt canbo)
	{
		try {
			canboService.addCbyt(canbo);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping(value = "admin/api/cbyt",method=RequestMethod.PUT)
	public ResponseEntity<Void>updateCanBo(@RequestBody Cbyt canbo)
	{
		try {
			canboService.updateCbyt(canbo);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "admin/api/cbyt/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCanBo(@PathVariable int id) {
		try {
			canboService.deleteCbyt(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "admin/api/countCbyt", method = RequestMethod.GET)
	public ResponseEntity<Long> getAmountCBYT() {
		return new ResponseEntity<>(canboService.Count(), HttpStatus.OK);
	}
	
}
