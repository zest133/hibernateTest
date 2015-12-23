package com.zest.hibernate.chapter8.manytomanymapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.zest.hibernate.chapter7.onetomanymapping.College;
import com.zest.hibernate.chapter7.onetomanymapping.Student;

public class ManyToMany {

	@Test
	public void manyTest(){
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Delegate.class);
		config.addAnnotatedClass(Event.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);

		// 아래 두개의 구문은 객체를 트랜잭션을 컨트롤.
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		Delegate d1 = new Delegate();
		d1.setDelegateName("shin");
		
		Delegate d2 = new Delegate();
		d2.setDelegateName("hwang");
		
		Delegate d3 = new Delegate();
		d3.setDelegateName("gno");
		
		Delegate d4 = new Delegate();
		d4.setDelegateName("byun");
		
		Event e1 = new Event();
		e1.setEventName("java - 101");
		
		Event e2 = new Event();
		e2.setEventName("c++ - 101");
		
		Event e3 = new Event();
		e3.setEventName("math - 101");
		
		e1.getDelegates().add(d1);
		e1.getDelegates().add(d2);
		e1.getDelegates().add(d3);
		
		e2.getDelegates().add(d2);
		e2.getDelegates().add(d3);
		
		e3.getDelegates().add(d4);
		
		session.save(d1);
		session.save(d2);
		session.save(d3);
		session.save(d4);
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		//session.save(alexdetail); 이건 안함. 카스케이드 라서 
		session.getTransaction().commit();
		
		
	}
}
