package com.suong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suong.dao.HealthDao;
import com.suong.entity.Cbyt;
import com.suong.entity.Hocsinh;
import com.suong.entity.Khamsuckhoe;
@Service
public class HealthServiceImpl implements HealthService{
	@Autowired
	private HealthDao healthDao;
	@Transactional
	public List<Khamsuckhoe> getAllHealth() {
	
		return healthDao.getAllHealth();
	}

	@Transactional
	public Khamsuckhoe getHealth(int id) {
		// TODO Auto-generated method stub
		return healthDao.getHealth(id);
	}

	@Transactional
	public void addHealth(Khamsuckhoe health) {
	healthDao.addHealth(health);
	}

	@Transactional
	public void deleteHealth(int id) {
		healthDao.deleteHealth(id);
		
	}

	@Transactional
	public void updateHealth(Khamsuckhoe health) {
		healthDao.updateHealth(health);
		
	}

	@Transactional
	public List<Cbyt> getAllCBYT() {
		
		return healthDao.getAllCBYT();
	}
	@Transactional
	public List<Hocsinh> getAllStudent() {
		
		return healthDao.getAllStudent();
	}

	@Transactional
	public List<Hocsinh> getStudent(int id) {
	
		return healthDao.getStudent(id);
	}

}
