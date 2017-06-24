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
import com.suong.entity.Hocsinh;
import com.suong.entity.Khamsuckhoe;
import com.suong.entity.Nktheodoi;
import com.suong.service.TheoDoiService;

@RestController
public class TheoDoiController {
	@Autowired
	private TheoDoiService theodoiService;
	@RequestMapping(value = "admin/api/follow",method=RequestMethod.GET)
	public ResponseEntity<List<Nktheodoi>>getAllClasses()
	{
		return new ResponseEntity<List<Nktheodoi>>(theodoiService.getAllTheoDoi(),HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/follow/{id}",method=RequestMethod.GET)
	public ResponseEntity<Nktheodoi>getNktheodoi(@PathVariable int id)
	{
		Nktheodoi theodoi;
		try {
			theodoi = theodoiService.getTheoDoi(id);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(theodoi,HttpStatus.OK);
	}
	@RequestMapping(value = "admin/api/follow",method=RequestMethod.POST)
	public ResponseEntity<Void>addTheodoi(@RequestBody Nktheodoi theodoi)
	{
		try {
			theodoiService.addTheoDoi(theodoi);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping(value = "admin/api/follow",method=RequestMethod.PUT)
	public ResponseEntity<Void>updateTheoDoi(@RequestBody Nktheodoi theodoi)
	{
		try {
			theodoiService.updateTheoDoi(theodoi);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "admin/api/follow/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTheoDoi(@PathVariable int id) {
		try {
			theodoiService.deleteTheodoi(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "admin/api/theodoihs", method = RequestMethod.GET)
	public ResponseEntity<List<Hocsinh>> getAllTheoDoiStudent() {
		return new ResponseEntity<>(theodoiService.getAllStudent(), HttpStatus.OK);
	}
	
}
