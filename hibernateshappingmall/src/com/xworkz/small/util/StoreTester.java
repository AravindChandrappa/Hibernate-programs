package com.xworkz.small.util;

import com.xworkz.small.dao.IStoreDAO;
import com.xworkz.small.dao.StoreDAO;
import com.xworkz.small.dto.StoreDTO;

public class StoreTester {
	
	public static void main(String[] args) {
		
		StoreDTO dto=new StoreDTO();
		
		 dto.setName("Orien");
		 dto.setNoOfStores(20);
		 dto.setStoreType("bangalore");
		 
		 IStoreDAO dao=new StoreDAO();
		 
		 dao.insert(dto);
		 
		 StoreDTO dto2=dao.getById(10);
		 
		 if(dto2!=null)
		 {
			 System.out.println("element found");
			 System.out.println(dto2);
		 }
		 else
		 {
			 System.out.println("element not found");
		 }
	}

}
