package com.xworkz.message.dao;

import java.util.List;

import com.xworkz.message.dto.MessageDTO;

public interface IMessageDAO {
	
	public Integer save(MessageDTO dto);
	public MessageDTO getById(int id);
	public void updateMessage(String sender, int id );
	public void deleteMessage(int id);
	public void createAll(List<MessageDTO> mList);
	

}
