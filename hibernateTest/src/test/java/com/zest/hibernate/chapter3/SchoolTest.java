package com.zest.hibernate.chapter3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.zest.hibernate.chapter2.Customer;

public class SchoolTest {

	@Test
	public void school1() {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(School.class);
		config.configure("hibernate.cfg.xml");

		new SchemaExport(config).create(true, true);

		// 아래 두개의 구문은 객체를 트랜잭션을 컨트롤.
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		SchoolDetail annsDetail= new SchoolDetail();
		annsDetail.setPublishSchool(false);
		annsDetail.setSchoolAddress("101 washington");
		annsDetail.setStudentCount(300);
		
		School stanns = new School();
		stanns.setSchoolName("st. anns school");
		stanns.setSchoolDetail(annsDetail);
		
		session.save(stanns);
		session.getTransaction().commit();
	}
}
