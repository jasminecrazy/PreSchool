package com.suong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suong.dao.NhapHocDao;
import com.suong.entity.Employee;
import com.suong.entity.Hocsinh;
import com.suong.entity.Nkdkh;
import com.suong.entity.Phuhuynh;

@Service
public class NhapHocServiceImpl implements NhapHocService {
	@Autowired
	private NhapHocDao nhaphocDao;

	@Transactional
	public List<Nkdkh> getAllDonDK() {
		return nhaphocDao.getAllDonDK();
	}

	@Transactional
	public Nkdkh getDonDk(int id) {

		return nhaphocDao.getDonDk(id);
	}

	@Transactional
	public void addDonDk(Nkdkh dondk) {
		nhaphocDao.addDonDk(dondk);

	}

	@Transactional
	public void deleteDonDK(int id) {
		nhaphocDao.deleteDonDK(id);

	}

	@Transactional
	public void updateDonDK(Nkdkh dondk) {
		nhaphocDao.updateDonDK(dondk);

	}

	@Transactional
	public List<Phuhuynh> getAllParent() {
		return nhaphocDao.getAllParent();
	}

	@Transactional
	public List<Hocsinh> getAllStudent() {
		return nhaphocDao.getAllStudent();
	}

	@Transactional
	public List<Employee> getAllEmployee() {

		return nhaphocDao.getAllEmployee();
	}

}
