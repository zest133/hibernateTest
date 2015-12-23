package com.zest.hibernate.chapter5.inheritancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.zest.hibernate.chapter2.Customer;


public class InheritaceMappingTest {

	@Test
	public void defaultRunTableTest(){
		Configuration config = new Configuration();
		config.addAnnotatedClass(Project.class);
		config.addAnnotatedClass(Module.class);
		config.addAnnotatedClass(Task.class);
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
		
		Project p = new Project();
		p.setProjectName("hibernate lessons");
		
		Module m = new Module();
		m.setProjectName("spring lessons");
		m.setModuleName("aop");
		
		Task t = new Task();
		t.setProjectName("java lessons");
		t.setModuleName("collections");
		t.setTaskName("arraylist");
		
		session.save(p);
		session.save(m);
		session.save(t);
		
		session.getTransaction().commit();
	}
	
	@Test
	public void singleTableTest(){
		Configuration config = new Configuration();
		config.addAnnotatedClass(Project.class);
		config.addAnnotatedClass(Module.class);
		config.addAnnotatedClass(Task.class);
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
		
		Project p = new Project();
		p.setProjectName("hibernate lessons");
		
		Module m = new Module();
		m.setProjectName("spring lessons");
		m.setModuleName("aop");
		
		Task t = new Task();
		t.setProjectName("java lessons");
		t.setModuleName("collections");
		t.setTaskName("arraylist");
		
		session.save(p);
		session.save(m);
		session.save(t);
		
		session.getTransaction().commit();
	}
}
