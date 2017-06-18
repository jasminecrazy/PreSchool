package com.suong.service;

import java.util.List;

import com.suong.entity.Class1;
import com.suong.entity.Phuhuynh;

public interface PhuHuynhService {
	public List<Phuhuynh> getAllPhuhuynh();

	public Phuhuynh getPhuhuynh(int id);

	public void addPhuhuynh(Phuhuynh phuhuynh);

	public void deletePhuhuynh(int id);

	public void updatePhuhuynh(Phuhuynh phuhuynh);
}
