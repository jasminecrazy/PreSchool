package com.suong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suong.dao.ClassDao;
import com.suong.entity.Class1;

@Service
public class ClassServiceImpl implements ClassService{

	@Autowired
	private ClassDao classDao;
		@Transactional
	public List<Class1> getAllClass() {
			return classDao.getAllClass();
	}

	@Transactional
	public Class1 getIClass(int id) {
		return classDao.getIClass(id);
	}

	@Transactional
	public void addIClass(Class1 iclass) {
		classDao.addIClass(iclass);
		
	}

	@Transactional
	public void deleteIClass(int id) {
		classDao.deleteIClass(id);
		
	}

	@Transactional
	public void updateIClass(Class1 iclass) {
		classDao.updateIClass(iclass);
		
	}

}
