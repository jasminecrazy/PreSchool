package com.suong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suong.dao.CBYTDao;
import com.suong.entity.Cbyt;
@Service
public class CBYTServiceImpl implements CBYTService{
	@Autowired
 private CBYTDao canboDao;
	@Transactional
	public List<Cbyt> getAllCbyt() {
		
		return canboDao.getAllCbyt();
	}

	@Transactional
	public Cbyt getCbyt(int id) {
		
		return canboDao.getCbyt(id);
	}

	@Transactional
	public void addCbyt(Cbyt canbo) {
		canboDao.addCbyt(canbo);
		
	}

	@Transactional
	public void deleteCbyt(int id) {
		canboDao.deleteCbyt(id);
		
	}

	@Transactional
	public void updateCbyt(Cbyt canbo) {
		canboDao.updateCbyt(canbo);
		
	}

	@Transactional
	public Long Count() {
		
		return canboDao.Count();
	}

}
