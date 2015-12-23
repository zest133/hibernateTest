package com.zest.hibernate.chapter1;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class EntityTest {
//	@Test
//	public void entityTest1(){
//		Configuration config = new Configuration();
//		config.addAnnotatedClass(Employee.class);
//		//db 접속 정보들을 저장.
//		config.configure("hibernate.cfg.xml");
//		
//		//db 접속후 여러개의 테이블을 자동으로 제너레이트 해주는 객체.
//		//<property name="hibernate.default_schema">TESTSCHEMA</property> 이구문역시 마찬가지임.
//		
//		
//		
//		config.addAnnotatedClass(Employee.class);
//		config.configure("hibernate.cfg.xml");
//		
//		new SchemaExport(config).create(true,true);
//		
//		
//	}
	
//	@Test
//	public void entityTest2(){
//		Configuration config = new Configuration();
//		config.addAnnotatedClass(Employee.class);
//		//db 접속 정보들을 저장.
//		config.configure("hibernate.cfg.xml");
//		
//		//db 접속후 여러개의 테이블을 자동으로 제너레이트 해주는 객체.
//		//<property name="hibernate.default_schema">TESTSCHEMA</property> 이구문역시 마찬가지임.
//		new SchemaExport(config).create(true,true);
//		
//		//아래 두개의 구문은 객체를 트랜잭션을 컨트롤. 
//	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
//	            config.getProperties()).build();
//		
//		
//		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
//		Session session = factory.getCurrentSession();
//		
//		session.beginTransaction();
//		
//		Employee alex = new Employee();
//		alex.setEmpName("Alex Berry");
//		alex.setEmpEmailAddress("aaa@aa.com");
//		session.save(alex);
//		
//		session.getTransaction().commit();
//	}
	
	@Test
	public void entityTest3(){
		//hibernate의 persitst를 위한 클래스
		Configuration config = new Configuration();
		config.addAnnotatedClass(Employee.class);
		//db 접속 정보들을 저장.
		config.configure("hibernate.cfg.xml");
		
		//db 접속후 여러개의 테이블을 자동으로 제너레이트 해주는 객체.
		//<property name="hibernate.default_schema">TESTSCHEMA</property> 이구문역시 마찬가지임.
		new SchemaExport(config).create(true,true);
		
		//아래 두개의 구문은 객체를 트랜잭션을 컨트롤. 
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            config.getProperties()).build();
		
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Employee alex = new Employee();
//		alex.setEmpId(2);
		alex.setEmpName("Alex Berry11");
		alex.setEmpEmailAddress("alex@hibernate.com");
		alex.setEmpPassword("alexpass");
		alex.setEmpJoinDate(new GregorianCalendar(2009,05,26));
		alex.setEmpLoginTime(Date.valueOf("2010-06-05"));
		session.save(alex);
		
		session.getTransaction().commit();
	}
}
