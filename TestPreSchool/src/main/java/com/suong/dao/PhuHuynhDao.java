package com.suong.dao;

import java.util.List;

import com.suong.entity.Class1;
import com.suong.entity.Phuhuynh;

public interface PhuHuynhDao {
	public List<Phuhuynh> getAllPhuhuynh();

	public Phuhuynh getPhuhuynh(int id);

	public void addPhuhuynh(Phuhuynh phuhuynh);

	public void deletePhuhuynh(int id);

	public void updatePhuhuynh(Phuhuynh phuhuynh);
}
