package com.suong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suong.dao.PhanLopDao;
import com.suong.entity.Class1;
import com.suong.entity.Hocsinh;
import com.suong.entity.Phanlop;

@Service
public class PhanLopServiceImpl implements PhanLopService {
	@Autowired
	private PhanLopDao phanlopDao;

	@Transactional
	public List<Phanlop> getAllPhanLop() {
		return phanlopDao.getAllPhanLop();
	}

	@Transactional
	public Phanlop getPhanLop(int id) {
		return phanlopDao.getPhanLop(id);
	}

	@Transactional
	public void addPhanLop(Phanlop phanlop) {
		phanlopDao.addPhanLop(phanlop);

	}

	@Transactional
	public void deletePhanLop(int id) {
		phanlopDao.deletePhanLop(id);

	}

	@Transactional
	public void updatePhanLop(Phanlop phanlop) {
		phanlopDao.updatePhanLop(phanlop);

	}

	@Transactional
	public List<Hocsinh> getAllStudent() {

		return phanlopDao.getAllStudent();
	}

	@Transactional
	public List<Class1> getAllClass() {
		return phanlopDao.getAllClass();
	}

}
