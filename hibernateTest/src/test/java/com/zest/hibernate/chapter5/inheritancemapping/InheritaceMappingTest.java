package com.zest.hibernate.chapter5.inheritancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


public class InheritaceMappingTest {

//	@Test
//	public void defaultRunTableTest(){
//		AnnotationConfiguration config = new AnnotationConfiguration();
//		config.addAnnotatedClass(Project.class);
//		config.addAnnotatedClass(Module.class);
//		config.addAnnotatedClass(Task.class);
//		config.configure("hibernate.cfg.xml");
//
//		new SchemaExport(config).create(true, true);
//
//		// 아래 두개의 구문은 객체를 트랜잭션을 컨트롤.
//		SessionFactory factory = config.buildSessionFactory();
//		Session session = factory.getCurrentSession();
//
//		session.beginTransaction();
//		
//		Project p = new Project();
//		p.setProjectName("hibernate lessons");
//		
//		Module m = new Module();
//		m.setProjectName("spring lessons");
//		m.setModuleName("aop");
//		
//		Task t = new Task();
//		t.setProjectName("java lessons");
//		t.setModuleName("collections");
//		t.setTaskName("arraylist");
//		
//		session.save(p);
//		session.save(m);
//		session.save(t);
//		
//		session.getTransaction().commit();
//	}
	
	@Test
	public void singleTableTest(){
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Project.class);
		config.addAnnotatedClass(Module.class);
		config.addAnnotatedClass(Task.class);
		config.configure("hibernate.cfg.xml");

		new SchemaExport(config).create(true, true);

		// 아래 두개의 구문은 객체를 트랜잭션을 컨트롤.
		SessionFactory factory = config.buildSessionFactory();
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
