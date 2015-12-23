package com.zest.hibernate.chapter10.crud;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.zest.hibernate.chapter1.Employee;

public class CrudTest {

	// insert
	@Test
	public void insertTest() {

		// hibernate의 persitst를 위한 클래스
		Configuration config = new Configuration();
		config.addAnnotatedClass(UserDetails.class);
		//db 접속 정보들을 저장.
		config.configure("hibernate.cfg.xml");
		
		//db 접속후 여러개의 테이블을 자동으로 제너레이트 해주는 객체.
		//<property name="hibernate.default_schema">TESTSCHEMA</property> 이구문역시 마찬가지임.
		new SchemaExport(config).create(true,true);
		
		//아래 두개의 구문은 객체를 트랜잭션을 컨트롤. 
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            config.getProperties()). buildServiceRegistry();
		
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		for (int i = 0; i < 10; i++) {
			UserDetails user = new UserDetails();
			user.setUserName("user " + i);
			session.save(user);
		}

		session.getTransaction().commit();
		// session.close();
	}

	@Test
	public void getTest() {

		// hibernate의 persitst를 위한 클래스
		Configuration config = new Configuration();
		config.addAnnotatedClass(UserDetails.class);
		//db 접속 정보들을 저장.
		config.configure("hibernate.cfg.xml");
		
		//db 접속후 여러개의 테이블을 자동으로 제너레이트 해주는 객체.
		//<property name="hibernate.default_schema">TESTSCHEMA</property> 이구문역시 마찬가지임.
		new SchemaExport(config).create(true,true);
		
		//아래 두개의 구문은 객체를 트랜잭션을 컨트롤. 
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            config.getProperties()). buildServiceRegistry();
		
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 6); 
		System.out.println("name\t"+user.getUserName());

		session.getTransaction().commit();
//		 session.close();
	}
	
	@Test
	public void deleteTest() {

		// hibernate의 persitst를 위한 클래스
		Configuration config = new Configuration();
		config.addAnnotatedClass(UserDetails.class);
		//db 접속 정보들을 저장.
		config.configure("hibernate.cfg.xml");
		
		//db 접속후 여러개의 테이블을 자동으로 제너레이트 해주는 객체.
		//<property name="hibernate.default_schema">TESTSCHEMA</property> 이구문역시 마찬가지임.
		new SchemaExport(config).create(true,true);
		
		//아래 두개의 구문은 객체를 트랜잭션을 컨트롤. 
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            config.getProperties()). buildServiceRegistry();
		
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
		session.delete(user);
		System.out.println("name\t"+user.getUserName());

		session.getTransaction().commit();
//		 session.close();
	}
	
	@Test
	public void updateTest() {

		// hibernate의 persitst를 위한 클래스
		Configuration config = new Configuration();
		config.addAnnotatedClass(UserDetails.class);
		//db 접속 정보들을 저장.
		config.configure("hibernate.cfg.xml");
		
		//db 접속후 여러개의 테이블을 자동으로 제너레이트 해주는 객체.
		//<property name="hibernate.default_schema">TESTSCHEMA</property> 이구문역시 마찬가지임.
		new SchemaExport(config).create(true,true);
		
		//아래 두개의 구문은 객체를 트랜잭션을 컨트롤. 
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            config.getProperties()). buildServiceRegistry();
		
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
		user.setUserName("update user");
		session.update(user);
		System.out.println("name\t"+user.getUserName());

		session.getTransaction().commit();
//		 session.close();
	}
	
	@Test
	public void hsqlTest1() {

		// hibernate의 persitst를 위한 클래스
		Configuration config = new Configuration();
		config.addAnnotatedClass(UserDetails.class);
		//db 접속 정보들을 저장.
		config.configure("hibernate.cfg.xml");
		
		//db 접속후 여러개의 테이블을 자동으로 제너레이트 해주는 객체.
		//<property name="hibernate.default_schema">TESTSCHEMA</property> 이구문역시 마찬가지임.
		new SchemaExport(config).create(true,true);
		
		//아래 두개의 구문은 객체를 트랜잭션을 컨트롤. 
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            config.getProperties()). buildServiceRegistry();
		
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		//hibernate 용으로. 
		Query query=  session.createQuery("from UserDetails");
		List users = query.list();
		

		session.getTransaction().commit();
//		 session.close();
		System.out.println("list size==>"+users.size());
	}
//	
	@Test
	public void hsqlWhereTest() {

		// hibernate의 persitst를 위한 클래스
		Configuration config = new Configuration();
		config.addAnnotatedClass(UserDetails.class);
		//db 접속 정보들을 저장.
		config.configure("hibernate.cfg.xml");
		
		//db 접속후 여러개의 테이블을 자동으로 제너레이트 해주는 객체.
		//<property name="hibernate.default_schema">TESTSCHEMA</property> 이구문역시 마찬가지임.
		new SchemaExport(config).create(true,true);
		
		//아래 두개의 구문은 객체를 트랜잭션을 컨트롤. 
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            config.getProperties()). buildServiceRegistry();
		
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		//hibernate 용으로. 
		Query query=  session.createQuery("from UserDetails where userId >5");
		List users = query.list();
		

		session.getTransaction().commit();
//		 session.close();
		System.out.println("list size==>"+users.size());
	}
//	
	
	@Test
	public void hsqlpageingTest1() {

		// hibernate의 persitst를 위한 클래스
		Configuration config = new Configuration();
		config.addAnnotatedClass(UserDetails.class);
		//db 접속 정보들을 저장.
		config.configure("hibernate.cfg.xml");
		
		//db 접속후 여러개의 테이블을 자동으로 제너레이트 해주는 객체.
		//<property name="hibernate.default_schema">TESTSCHEMA</property> 이구문역시 마찬가지임.
		new SchemaExport(config).create(true,true);
		
		//아래 두개의 구문은 객체를 트랜잭션을 컨트롤. 
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            config.getProperties()). buildServiceRegistry();
		
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		//hibernate 용으로. 
		Query query=  session.createQuery("from UserDetails where userId >5");
		List<UserDetails> users = (List<UserDetails>)query.list();
		

		session.getTransaction().commit();
//		 session.close();
		for(UserDetails u : users){
			System.out.println(u.getUserName());
		}
	}
	
	@Test
	public void hsqlpageingTest2() {

		// hibernate의 persitst를 위한 클래스
		Configuration config = new Configuration();
		config.addAnnotatedClass(UserDetails.class);
		//db 접속 정보들을 저장.
		config.configure("hibernate.cfg.xml");
		
		//db 접속후 여러개의 테이블을 자동으로 제너레이트 해주는 객체.
		//<property name="hibernate.default_schema">TESTSCHEMA</property> 이구문역시 마찬가지임.
		new SchemaExport(config).create(true,true);
		
		//아래 두개의 구문은 객체를 트랜잭션을 컨트롤. 
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            config.getProperties()). buildServiceRegistry();
		
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		//hibernate 용으로. 
		Query query=  session.createQuery("from UserDetails ");
		//시작 row를 설정. 
		query.setFirstResult(5);
		//결과 개수
		query.setMaxResults(4);
		
		List<UserDetails> users = (List<UserDetails>)query.list();
		

		session.getTransaction().commit();
//		 session.close();
		for(UserDetails u : users){
			System.out.println(u.getUserName());
		}
	}
	
	@Test
	public void hsqlBindingTest2() {

		// hibernate의 persitst를 위한 클래스
		Configuration config = new Configuration();
		config.addAnnotatedClass(UserDetails.class);
		//db 접속 정보들을 저장.
		config.configure("hibernate.cfg.xml");
		
		//db 접속후 여러개의 테이블을 자동으로 제너레이트 해주는 객체.
		//<property name="hibernate.default_schema">TESTSCHEMA</property> 이구문역시 마찬가지임.
		new SchemaExport(config).create(true,true);
		
		//아래 두개의 구문은 객체를 트랜잭션을 컨트롤. 
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            config.getProperties()). buildServiceRegistry();
		
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		String minUserId= "5";
		//hibernate 용으로.
		
		
		Query query=  session.createQuery("from UserDetails where userId > ?");
		query.setInteger(0, Integer.parseInt(minUserId));
		List<UserDetails> users = (List<UserDetails>)query.list();
		

		session.getTransaction().commit();
//		 session.close();
		for(UserDetails u : users){
			System.out.println(u.getUserName());
		}
	}
}
