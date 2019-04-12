package com.xwz.hibernate.Test;

import com.xworkz.SFutil.SFutil;
import com.xwz.hibernate.dao.ILaptopDao;
import com.xwz.hibernate.dao.LaptopDao;
import com.xwz.hibernate.dto.LaptopDto;

public class LaptopTest {

	public static void main(String[] args) {
		
		/*LaptopDto dto=new LaptopDto();
		//dto.setLaptop_id(108);
		dto.setBrand("lenovo");
		dto.setWorking(true);
		dto.setOs("linux");
		dto.setPrice(23000.400);*/
		
		ILaptopDao dao=new LaptopDao();
		//dao.save(dto);
		
		//LaptopDto d=dao.getById(107);
		//System.out.println(d);
		
		ILaptopDao dao1=new LaptopDao();
		dao1.fetchByCriteria();
		
		
		
		SFutil.close();
	}
}
