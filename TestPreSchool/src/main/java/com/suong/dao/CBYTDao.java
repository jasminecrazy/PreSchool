package com.suong.dao;

import java.util.List;
import com.suong.entity.Cbyt;


public interface CBYTDao {
	public List<Cbyt> getAllCbyt();

	public Cbyt getCbyt(int id);

	public void addCbyt(Cbyt canbo);

	public void deleteCbyt(int id);

	public void updateCbyt(Cbyt canbo);
	public Long Count();
}
