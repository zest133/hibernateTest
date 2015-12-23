package com.zest.hibernate.chapter7.onetomanymapping;

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
import com.zest.hibernate.chapter6.onetoonemapping.Person;
import com.zest.hibernate.chapter6.onetoonemapping.PersonDetail;

public class OneToManyTest {

	@Test
	public void oneTest(){
		Configuration config = new Configuration();
		config.addAnnotatedClass(College.class);
		config.addAnnotatedClass(Student.class);
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
		
		College college1 = new College();
		college1.setCollegeName("Newyork College");
		
		Student s1 = new Student();
		s1.setStudentName("Alex Rod");
		
		Student s2 = new Student();
		s2.setStudentName("Linda Berry");
		
		s1.setCollege(college1);
		s2.setCollege(college1);
		
		session.save(college1);
		session.save(s1);
		session.save(s2);
		//session.save(alexdetail); 이건 안함. 카스케이드 라서 
		session.getTransaction().commit();
		
		
	}
}
