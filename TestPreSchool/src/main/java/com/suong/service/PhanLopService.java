package com.suong.service;

import java.util.List;

import com.suong.entity.Class1;
import com.suong.entity.Hocsinh;
import com.suong.entity.Phanlop;

public interface PhanLopService {
	public List<Phanlop> getAllPhanLop();

	public Phanlop getPhanLop(int id);

	public void addPhanLop(Phanlop phanlop);

	public void deletePhanLop(int id);

	public void updatePhanLop(Phanlop phanlop);
	public List<Hocsinh>getAllStudent();
	public List<Class1>getAllClass();
}
