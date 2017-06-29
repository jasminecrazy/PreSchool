package com.suong.service;

import java.util.List;

import com.suong.entity.Cbyt;


public interface CBYTService {
	public List<Cbyt> getAllCbyt();

	public Cbyt getCbyt(int id);

	public void addCbyt(Cbyt canbo);

	public void deleteCbyt(int id);

	public void updateCbyt(Cbyt canbo);
	public Long Count();
}
