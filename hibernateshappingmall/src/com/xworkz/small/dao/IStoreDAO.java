package com.xworkz.small.dao;

import com.xworkz.small.dto.StoreDTO;

public interface IStoreDAO {
	
	public Integer insert(StoreDTO dto);
	
	
	public StoreDTO getById(int id);

}
