package com.xworkz.gym.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.SFutil.SFutil;
import com.xworkz.gym.dto.GymDTO;
import com.xworkz.gym.util.ListIsEmptyOrNot;

public class GymDAOImpl implements GymDAO {

	SessionFactory factory = SFutil.geFactory();
	Session session = factory.openSession();

	public List<GymDTO> fetchAllRecordsFromDb() {

		System.out.println("Invoked into fetchAllRecords().....\n");
		
		System.out.println("session and factory object is created....");

		try {
			// String hqlSyntax ="select gym from GymDTO gym";
			// System.out.println("query:\t"+hqlSyntax);
			// Query query = session.createQuery(hqlSyntax);
			Query query = session.getNamedQuery("gym.fetchAll");
			System.out.println("query:\t" + query);
			List<GymDTO> list = query.list();
			if (!ListIsEmptyOrNot.isEmpty(list)) {
				System.out.println("record list found ");
				return list;
			} else {
				System.out.println("record list ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			//session.close();
		}

		return Collections.EMPTY_LIST;
	}

	@Override
	public List<String> fetchByNameAndLoctaion(String name) {
		
		System.out.println("invoked a method fetchByName()\n");
		try {
			Query query=session.getNamedQuery("gym.fetchName");
			query.setParameter("rc", name);
			System.out.println("query syntax: "+query);
			List<String> list=query.list();
			System.out.println("getByName records");
			if(!ListIsEmptyOrNot.isEmpty(list))
			{
				System.out.println("list of record found...");
				return list;
			}
			else
			{
				System.out.println("list of records not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			//session.close();
		}
		return Collections.EMPTY_LIST;
	}

	@Override
	public List<Object[]> fetchAllLocationAndType(String type) {

		try {
			System.out.println("invoked a fetchAllLocationAndType()\n");
			Query query=session.getNamedQuery("gym.fetchNameAndLocation");
			System.out.println("Query syntax: "+query);
			query.setParameter("typ", type);
			List<Object[]> objects=query.list();
			return objects;
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			//session.close();
		}
		return null;
	}

	@Override
	public List<Object[]> fetchAllGymNameAndLocationByParam() {
		
		try {
			System.out.println("invoked a fetchAllGymNameAndLocationByParam()\n");
			Query query=session.getNamedQuery("gym.fetAllList");
			System.out.println("Query syntax: "+query);
			List<Object[]> list=query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			//session.close();
		}
		return null;
	}

	public void updateLocationByName(String name,String location) {

		System.out.println("invoked a updateLocationByName()");
		Transaction transaction=session.beginTransaction();

		try {
			Query query=session.getNamedQuery("updateLocationByname");
			query.setParameter("loc", location);
			query.setParameter("nm", name);
			int id=query.executeUpdate();
			transaction.commit(); 
			System.out.println("Successfully updated...........");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			//session.close();
		}
		//return 0;
	}

	@Override
	public void deleteRecordByType(String type) {
		
		Transaction transaction=session.beginTransaction();

		System.out.println("invoked a deleteRecordByType()...");
		try {
			Query query=session.getNamedQuery("deleteRecordByType");
			query.setParameter("tp", type);
			int noOfRowsDeleted=query.executeUpdate();
			transaction.commit();
			System.out.println("Successfully deleted......"+noOfRowsDeleted);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			//session.close();
		}
	}

	@Override
	public Integer insertValues( List<GymDTO> dto) {
		System.out.println("invoked into insertValues(()\n");
		Transaction transaction=session.beginTransaction();

		try {
			for(GymDTO dtos:dto)
			{
			 Serializable id=session.save(dtos);
			 //System.out.println("successfully inserted with"+id);
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
		}
		
		return null;
	}
	

}
