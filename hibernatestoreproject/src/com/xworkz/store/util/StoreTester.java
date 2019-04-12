package com.xworkz.store.util;

import com.xworkz.store.dao.IStoreDAO;
import com.xworkz.store.dao.StoreDAO;
import com.xworkz.store.dto.StoreDTO;

public abstract class StoreTester {
	
	public static void main(String[] args) {
		
		StoreDTO dto=new StoreDTO();
		
		dto.setName("Malini");
		dto.setNoOfEmp(20);
		dto.setStoreType("Jewellery");
		
		IStoreDAO dao= new StoreDAO();
		
		dao.insert(dto);
		
		StoreDTO dto2=dao.getById(1);
		
		if(dto2!=null)
		{
			System.out.println("Id found");
			System.out.println(dto2);
		}
		else
		{
			System.out.println("not found");
		}
	}

}
