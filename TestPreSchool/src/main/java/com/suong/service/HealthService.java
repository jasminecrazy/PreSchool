package com.suong.service;

import java.util.List;

import com.suong.entity.Cbyt;
import com.suong.entity.Hocsinh;
import com.suong.entity.Khamsuckhoe;

public interface HealthService {
	public List<Khamsuckhoe> getAllHealth();

	public Khamsuckhoe getHealth(int id);

	public void addHealth(Khamsuckhoe health);

	public void deleteHealth(int id);

	public void updateHealth(Khamsuckhoe health);
	public List<Cbyt>getAllCBYT();
	public List<Hocsinh>getAllStudent();
	public List<Hocsinh>getStudent(int id);
}
