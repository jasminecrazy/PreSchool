package com.suong.dao;

import java.util.List;

import com.suong.entity.Hocsinh;
import com.suong.entity.Nktheodoi;

public interface TheoDoiDao {
	public List<Nktheodoi> getAllTheoDoi();

	public Nktheodoi getTheoDoi(int id);

	public void addTheoDoi(Nktheodoi theodoi);

	public void deleteTheodoi(int id);

	public void updateTheoDoi(Nktheodoi theodoi);

	public List<Hocsinh> getAllStudent();

	public List<Nktheodoi> getStudentt();
}
