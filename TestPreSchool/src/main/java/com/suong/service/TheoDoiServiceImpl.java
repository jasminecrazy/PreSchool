package com.suong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suong.dao.TheoDoiDao;
import com.suong.entity.Hocsinh;
import com.suong.entity.Nktheodoi;
@Service
public class TheoDoiServiceImpl implements TheoDoiService{
@Autowired
	private TheoDoiDao theodoiDao;
	@Transactional
	public List<Nktheodoi> getAllTheoDoi() {
		// TODO Auto-generated method stub
		return theodoiDao.getAllTheoDoi();
	}

	@Transactional
	public Nktheodoi getTheoDoi(int id) {
		// TODO Auto-generated method stub
		return theodoiDao.getTheoDoi(id);
	}

	@Transactional
	public void addTheoDoi(Nktheodoi theodoi) {
		theodoiDao.addTheoDoi(theodoi);
		
	}

	@Transactional
	public void deleteTheodoi(int id) {
		theodoiDao.deleteTheodoi(id);
		
	}

	@Transactional
	public void updateTheoDoi(Nktheodoi theodoi) {
		theodoiDao.updateTheoDoi(theodoi);
		
	}

	@Transactional
	public List<Hocsinh> getAllStudent() {
		
		return theodoiDao.getAllStudent();
	}

}
