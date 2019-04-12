package com.xwz.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.SFutil.SFutil;
import com.xwz.hibernate.dto.LaptopDto;

public class LaptopDao implements ILaptopDao {

	LaptopDto dto = null;
	SessionFactory factory = SFutil.geFactory();
	Session session = factory.openSession();

	public LaptopDao() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	public Integer save(LaptopDto laptop) {

		try {
			System.out.println("invoked save method");
			System.out.println("starting to save");
			System.out.println("not yet implemented");

			//factory = SFutil.geFactory();
			//session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Integer id = (Integer) session.save(laptop);
			System.out.println("data saved.....successfully");
			transaction.commit();
			System.out.println("transaction committed");
			System.out.println("ID: +id");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	@Override
	public LaptopDto getById(int id) {

		try {
			System.out.println("invoked a getById().....");
			//factory = SFutil.geFactory();
			//session = factory.openSession();
			System.out.println("session created");
			LaptopDto dto = session.get(LaptopDto.class, id);
			// System.out.println(dto);
			System.out.println("Data retrived from db");

			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
		}
		return null;

	}

	@Override
	public Integer insertValues(List<LaptopDto> dto) {

		System.out.println("invoked insertValues().... trying to insert list of values");
		SessionFactory factory = SFutil.geFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			for (LaptopDto dto2 : dto) {
				session.save(dto);
			}
			transaction.commit();
			System.out.println("successfully saved into database......");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
		}
		return null;
	}
	public void fetchByCriteria()
	{
		System.out.println("invoked into criteria()");
		try {
			
			Criteria criteria=session.createCriteria(LaptopDto.class);
			List<LaptopDto> list=criteria.list();
			System.out.println("Retrieved records from Db:");
			//System.out.println(list);	
			for(LaptopDto dto:list)
			{
				System.out.println(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
		}
	}
}
