package com.zest.hibernate.chapter3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.zest.hibernate.chapter10.crud.UserDetails;
import com.zest.hibernate.chapter2.Customer;

public class SchoolTest {

	@Test
	public void school1() {
		Configuration config = new Configuration();
		config.addAnnotatedClass(School.class);
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
