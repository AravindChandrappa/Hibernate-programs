package com.xwz.hibernate.dao;

import java.util.List;

import com.xwz.hibernate.dto.LaptopDto;

public interface ILaptopDao {
	
	public Integer save(LaptopDto dto);
	
	public LaptopDto getById(int id);
	
	public Integer insertValues(List<LaptopDto> dto );
	
	public  void fetchByCriteria();

}
