package com.zest.hibernate.chapter6.onetoonemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.zest.hibernate.chapter5.inheritancemapping.Module;
import com.zest.hibernate.chapter5.inheritancemapping.Project;
import com.zest.hibernate.chapter5.inheritancemapping.Task;

public class OneToOneTest {

	@Test
	public void oneTest(){
		Configuration config = new Configuration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(PersonDetail.class);
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
		
		PersonDetail alexDetail = new PersonDetail();
		alexDetail.setZipCode("20815");
		alexDetail.setJob("Accountant");
		alexDetail.setIncome(67245.56);
		
		Person alex = new Person();
		alex.setPersonName("alex berry");
		
		alex.setpDetail(alexDetail);
		
		session.save(alex);
		//session.save(alexdetail); 이건 안함. 카스케이드 라서 
		session.getTransaction().commit();
		
		
	}
}
