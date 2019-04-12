package com.xworkz.message.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xworkz.SFutil.SFutil;
import com.xworkz.message.dao.IHqlDAO;
import com.xworkz.message.dao.IMessageDAO;
import com.xworkz.message.dao.MessageDAO;
import com.xworkz.message.dto.MessageDTO;

public class MessageTester {
	
	public static void main(String[] args) {
		
		MessageDTO dto1=new MessageDTO("Sagar","Govind","Told me the interview process",new Date());
		MessageDTO dto2=new MessageDTO("drravid","kohli","hii guru you performance",new Date());
		MessageDTO dto3=new MessageDTO("channakeshav","gandhi","Independency is august",new Date());

		
		List<MessageDTO> mList=new ArrayList<MessageDTO>();
		mList.add(dto1);
		mList.add(dto2);
		mList.add(dto3);
		
		List<MessageDTO> pList=new ArrayList<MessageDTO>();
		pList.addAll(mList);
		
		
		IMessageDAO dao=new MessageDAO();
		IHqlDAO dao2=new MessageDAO();
		dao.save(dto2);
		//dao.save(dto, dto2);
		//MessageDTO dto=dao.getById(4);
		//System.out.println("\nIn main class -->Data from Dataase= "+dto+"\n");
		//dao.updateMessage("Sundhar", 4);
		//dao.deleteMessage(3);
		//dao.createAll(pList);
		MessageDTO dto=dao2.fetchByReciever("shekar");
		System.out.println(dto);
		SFutil.close();
	}

}
