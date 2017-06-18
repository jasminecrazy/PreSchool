package com.suong.service;

import java.util.List;

import com.suong.entity.Employee;
import com.suong.entity.Hocsinh;
import com.suong.entity.Nkdkh;
import com.suong.entity.Phuhuynh;

public interface NhapHocService {
	public List<Nkdkh> getAllDonDK();

	public Nkdkh getDonDk(int id);

	public void addDonDk(Nkdkh dondk);

	public void deleteDonDK(int id);

	public void updateDonDK(Nkdkh dondk);

	public List<Phuhuynh> getAllParent();

	public List<Hocsinh> getAllStudent();

	public List<Employee> getAllEmployee();
}
