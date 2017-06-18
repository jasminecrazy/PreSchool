package com.suong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suong.dao.PhuHuynhDao;
import com.suong.entity.Phuhuynh;

@Service
public class PhuHuynhServiceImpl implements PhuHuynhService {
	@Autowired
	private PhuHuynhDao phuhuynhDao;

	@Transactional
	public List<Phuhuynh> getAllPhuhuynh() {

		return phuhuynhDao.getAllPhuhuynh();
	}

	@Transactional
	public Phuhuynh getPhuhuynh(int id) {
		
		return phuhuynhDao.getPhuhuynh(id);
	}

	@Transactional
	public void addPhuhuynh(Phuhuynh phuhuynh) {
		phuhuynhDao.addPhuhuynh(phuhuynh);

	}

	@Transactional
	public void deletePhuhuynh(int id) {
		phuhuynhDao.deletePhuhuynh(id);

	}

	@Transactional
	public void updatePhuhuynh(Phuhuynh phuhuynh) {
		phuhuynhDao.updatePhuhuynh(phuhuynh);

	}

}
