package com.hib.hospital.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hib.hospital.dto.HospitalDto;

public class HospitalDao {

	public HospitalDao() {
		System.out.println("created: "+getClass().getSimpleName());
	}
	public void save(HospitalDto hospital){
		System.out.println("invoke save method");
		System.out.println("started save method");
		
	  Configuration configuration=new Configuration();
	  configuration.configure();
	  configuration.addAnnotatedClass(HospitalDto.class);
	  SessionFactory sessionFactory= configuration.buildSessionFactory();
	  Session session = sessionFactory.openSession();
	  Transaction transaction = session.beginTransaction();
	  session.save(hospital);
	  transaction.commit();
	  session.close();
	  sessionFactory.close();
	  
	}
}
