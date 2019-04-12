package com.hib.hospital.tester;

import com.hib.hospital.dao.HospitalDao;
import com.hib.hospital.dto.HospitalDto;

public class HospitalTester {
	
	public static void main(String[] args) {
		
		HospitalDto hospitalDto=new HospitalDto();
		
		hospitalDto.setHospital_id(108);
		hospitalDto.setName("Kidwai");
		hospitalDto.setLocation("Bangalore");
		hospitalDto.setSpecialization("Cancer");
		hospitalDto. setContactNo(98348688l);
		
		HospitalDao dao=new HospitalDao();
		dao.save(hospitalDto);
	}

}
