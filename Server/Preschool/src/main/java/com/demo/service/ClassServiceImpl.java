package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.ClassDao;
import com.demo.dao.StudentDao;
import com.demo.entity.Class1;
@Service
public class ClassServiceImpl implements ClassService{

	@Autowired
	private ClassDao classDao;

	@Transactional
	public Class1 getClass(int id) {
		return classDao.getClass(id);
	}

	@Transactional
	public void addClass(Class1 Class1) {
		classDao.addClass(Class1);
		
	}

	@Transactional
	public void deleteClass(int id) {
		classDao.deleteClass(id);
		
	}

	@Override
	public void updateClass(Class1 Class1) {
	 classDao.updateClass(Class1);
		
	}

	@Override
	public List<Class1> getAllClasses() {
		return classDao.getAllClasses();
	}

	

}
