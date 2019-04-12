package com.xworkz.SFutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SFutil {
	
	private static SessionFactory factory;
	
	public static SessionFactory geFactory(){
		
		System.out.println("Invoked geFactory()..... you will get factory object");
		return factory;
	}
	static
	{
		System.out.println("static block invoked configuration starts");
		
		Configuration configuration=new Configuration();
		System.out.println("configuration done looking for db.xml under resource");
		
		configuration.configure("resource/db.xml");
		System.out.println("db.xml found factory created below");
		
		factory=configuration.buildSessionFactory();
	}
	public static void close(){
		
		factory.close();
		
		System.out.println("factory closed");
	}
}
