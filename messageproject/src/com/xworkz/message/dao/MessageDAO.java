package com.xworkz.message.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.SFutil.SFutil;
import com.xworkz.message.dto.MessageDTO;

public class MessageDAO implements IMessageDAO,IHqlDAO {

	SessionFactory factory = SFutil.geFactory();
	Session session = factory.openSession();
	Transaction transaction;

	@Override
	public Integer save(MessageDTO dto) {

		System.out.println("invoked a save method.....");

		System.out.println("session instance created");
		try {

			Serializable id = session.save(dto);
			System.out.println("Id: " + id);
			 transaction=session.beginTransaction();
			transaction.commit();
			System.out.println("transaction commited successfully");
			return (Integer) id;
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			session.close();
		}

		return null;
	}

	@Override
	public MessageDTO getById(int id) {
		
		System.out.println("invoked a getById method....");
		
		try{
			
			MessageDTO dto=session.get(MessageDTO.class, id);
			System.out.println("Data from database= "+dto);
			return dto;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			session.close();
		}

		return null;
	}

	@Override
	public void updateMessage(String sender, int id) {
		System.out.println(sender); //update value getting from called by tester 
		transaction=session.beginTransaction(); // transaction begins with reference of session
		
		try{
			
			MessageDTO dto=session.get(MessageDTO.class, id); // getting entity object by id 
			if(dto!=null) // validating entity is exist or not
			{
				System.out.println("entity object found, u can update..");
				dto.setSender(sender); // setting new value for database record
				session.update(dto); // updating setted value, stored in cache
				transaction.commit(); // stored permanently in database
				System.out.println("successfully updated......");
			}
			else{
				System.out.println("entity not found....., u can not update");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			
			session.close();
		}
	}

	@Override
	public void deleteMessage(int id) {

		transaction=session.beginTransaction();
		try {
			
			MessageDTO dto=session.get(MessageDTO.class, id);
			session.delete(dto);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}
	}

	@Override
	public void createAll(List<MessageDTO> mList) {
	
		System.out.println("Invoked a createAll() in DAO class");
		transaction=session.beginTransaction();
		try {
			for(MessageDTO i:mList)
			{
				session.save(i);
			}
			System.out.println("");
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}
		
	}
	@Override
	public MessageDTO fetchByReciever(String recievr) {

		SessionFactory factory=SFutil.geFactory();
		Session session=factory.openSession();
		try {
			String hqlQuery="select message from MessageDTO message where message.reciever='"+recievr+"'";
			Query query=session.createQuery(hqlQuery);
			Object object=query.uniqueResult();
			if(object!=null)
			{
				System.out.println("you have to convert it into DTO");
				if(object instanceof MessageDTO)
				{
					System.out.println("object is from db");
					MessageDTO dto= (MessageDTO) object;
					return dto;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
