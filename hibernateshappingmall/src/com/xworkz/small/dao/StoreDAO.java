package com.xworkz.small.dao;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.small.dto.StoreDTO;

public class StoreDAO implements IStoreDAO {

	Properties properties = new Properties();	

	public StoreDAO() {
		System.out.println("created: " + this.getClass().getSimpleName());
	}

	@Override
	public Integer insert(StoreDTO dto) {
		
		System.out.println("Invoked insert");

		SessionFactory factory = null;
		Session session = null;

		try {
			System.out.println("---------");
			properties.load(StoreDAO.class.getClassLoader().getResourceAsStream("resource/hibernate.properties"));
			System.out.println("---------");
			factory = new Configuration().addAnnotatedClass(StoreDTO.class).addProperties(properties).buildSessionFactory();
			System.out.println("---------");
			session = factory.openSession();
			System.out.println("Testing session"+session.isConnected());
			Transaction transaction = session.beginTransaction();
			Integer id = (Integer) session.save(dto);
			transaction.commit();
			System.out.println("Id :" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			session.close();
			factory.close();
		}

		return null;
	}

	@Override
	public StoreDTO getById(int id) {
		StoreDTO dto=null;
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		//Integer id = null;

		try {
			properties.load(StoreDAO.class.getClassLoader().getResourceAsStream("resource/hibernate.properties"));

			factory = new Configuration().addAnnotatedClass(StoreDTO.class).addProperties(properties).buildSessionFactory();

			session = factory.openSession();

			transaction = session.beginTransaction();
			//session.save(dto);
			 dto=session.get(StoreDTO.class, id);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}
		return dto;

	}

}
