package com.suong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suong.dao.ClassDao;
import com.suong.entity.Giaovien;
import com.suong.entity.Hocsinh;
import com.suong.entity.Iclass;

@Service
public class ClassServiceImpl implements ClassService{

	@Autowired
	private ClassDao classDao;
		@Transactional
	public List<Iclass> getAllClass() {
			return classDao.getAllClass();
	}

	@Transactional
	public Iclass getIClass(int id) {
		return classDao.getIClass(id);
	}

	@Transactional
	public void addIClass(Iclass iclass) {
		classDao.addIClass(iclass);
		
	}

	@Transactional
	public void deleteIClass(int id) {
		classDao.deleteIClass(id);
		
	}

	@Transactional
	public void updateIClass(Iclass iclass) {
		classDao.updateIClass(iclass);
		
	}

	@Transactional
	public List<Giaovien> getAllTeacher() {
		return classDao.getAllTeacher();
	}

	@Transactional
	public List<Hocsinh> getStudent(int id) {
				return classDao.getStudent(id);
	}

	@Transactional
	public List<Hocsinh> getIStudent(int id) {
		return classDao.getIStudent(id);
	}

}
