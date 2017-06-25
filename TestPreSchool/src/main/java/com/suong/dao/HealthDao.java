package com.suong.dao;

import java.util.List;

import com.suong.entity.Cbyt;
import com.suong.entity.Hocsinh;
import com.suong.entity.Khamsuckhoe;


public interface HealthDao {
	public List<Khamsuckhoe> getAllHealth();

	public Khamsuckhoe getHealth(int id);

	public void addHealth(Khamsuckhoe health);

	public void deleteHealth(int id);

	public void updateHealth(Khamsuckhoe health);
	public List<Cbyt>getAllCBYT();
	public List<Hocsinh>getAllStudent();
	public List<Hocsinh>getStudent(int id);
}
