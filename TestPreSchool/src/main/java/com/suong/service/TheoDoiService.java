package com.suong.service;

import java.util.List;

import com.suong.entity.Hocsinh;
import com.suong.entity.Nktheodoi;

public interface TheoDoiService {
	public List<Nktheodoi>getAllTheoDoi();

	public Nktheodoi getTheoDoi(int id);

	public void addTheoDoi(Nktheodoi theodoi);

	public void deleteTheodoi(int id);

	public void updateTheoDoi(Nktheodoi theodoi);
	public List<Hocsinh>getAllStudent();
}
