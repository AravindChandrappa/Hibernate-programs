package com.xworkz.message.dao;

import com.xworkz.message.dto.MessageDTO;

public interface IHqlDAO {

	public MessageDTO fetchByReciever(String recievr);
}
