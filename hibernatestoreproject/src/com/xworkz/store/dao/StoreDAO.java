package com.xworkz.store.dao;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.store.dto.StoreDTO;

public class StoreDAO implements IStoreDAO {

	public StoreDAO() {
		System.out.println("created: " + this.getClass().getSimpleName());
	}

	@Override
	public Integer insert(StoreDTO storeDto) {
		Session session = null;
		SessionFactory factory = null;
		//Properties properties=new Properties();
		try {
			Configuration configuration = new Configuration();
			configuration.configure("resource/hibernate.cfg.xml");  // using xml
			configuration.addAnnotatedClass(StoreDTO.class);
			factory=configuration.buildSessionFactory();
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			System.out.println("Getting id ");
			Integer i=(Integer) session.save(storeDto);
			transaction.commit();
			System.out.println("Id= "+i);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("all resources are closing here");
			session.close();
			factory.close();
		}
		return null;
	}

	@Override
	public StoreDTO getById(int id) {


		Configuration configuration=new Configuration();
		configuration.configure("resource/hibernate.cfg.xml");
		configuration.addAnnotatedClass(StoreDTO.class);
		SessionFactory factory= configuration.buildSessionFactory();
		
		
		Session session=factory.openSession();
		Transaction transaction= session.beginTransaction();
		StoreDTO dto=session.get(StoreDTO.class, id);
		
		return dto;
	}

}
