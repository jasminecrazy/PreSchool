package com.suong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suong.dao.ThuTienDao;
import com.suong.entity.Hocsinh;
import com.suong.entity.Thutienhoc;
@Service
public class ThuTienServiceImpl implements ThuTienService{
	@Autowired
	private ThuTienDao thutienDao;
	@Transactional
	public List<Thutienhoc> getAllTien() {
		
		return thutienDao.getAllTien();
	}

	@Transactional
	public Thutienhoc getTien(int id) {
		// TODO Auto-generated method stub
		return thutienDao.getTien(id);
	}

	@Transactional
	public void addTien(Thutienhoc tien) {
		thutienDao.addTien(tien);
		
	}

	@Transactional
	public void deleteTien(int id) {
		thutienDao.deleteTien(id);
	}

	@Transactional
	public void updateTien(Thutienhoc tien) {
		thutienDao.updateTien(tien);
		
	}

	@Transactional
	public List<Hocsinh> getAllStudents() {
	
		return thutienDao.getAllStudents();
	}

	@Transactional
	public List<Thutienhoc> getStuden(int id) {
		// TODO Auto-generated method stub
		return thutienDao.getStuden(id);
	}

}
