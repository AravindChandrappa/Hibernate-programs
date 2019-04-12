package com.xworkz.gym.dao;

import java.util.List;

import com.xworkz.gym.dto.GymDTO;

public interface GymDAO {

	public List<GymDTO> fetchAllRecordsFromDb();
	
	public List<String> fetchByNameAndLoctaion(String name);
	
	public List<Object[]> fetchAllLocationAndType(String type);
	
	public List<Object[]> fetchAllGymNameAndLocationByParam();
	
	public void updateLocationByName(String name,String location);
	
	public void deleteRecordByType(String type);
	
	public Integer insertValues(List<GymDTO> dto);
	
	
}
