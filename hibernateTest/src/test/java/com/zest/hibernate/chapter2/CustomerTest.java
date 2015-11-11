package com.zest.hibernate.chapter2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class CustomerTest {

	@Test
	public void customer1() {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Customer.class);
		config.configure("hibernate.cfg.xml");

		new SchemaExport(config).create(true, true);

		// 아래 두개의 구문은 객체를 트랜잭션을 컨트롤.
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Customer alex = new Customer();
		alex.setCustomerName("Alex Rod");
		alex.setCustomerAddress("101 washington");
		alex.setCreditScore(780);
		alex.setRewardPoints(12000);
		
		session.save(alex);
		session.getTransaction().commit();
	}
}
