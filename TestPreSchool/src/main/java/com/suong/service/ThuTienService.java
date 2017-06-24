package com.suong.service;

import java.util.List;

import com.suong.entity.Hocsinh;
import com.suong.entity.Thutienhoc;

public interface ThuTienService {
	public List<Thutienhoc>getAllTien();

	public Thutienhoc getTien(int id);

	public void addTien(Thutienhoc tien);

	public void deleteTien(int id);

	public void updateTien(Thutienhoc tien);
	public List<Hocsinh>getAllStudents();
}
