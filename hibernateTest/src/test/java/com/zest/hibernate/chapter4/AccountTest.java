package com.zest.hibernate.chapter4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.zest.hibernate.chapter3.School;


public class AccountTest {

	@Test
	public void account1() {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Accounts.class);
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

		CompoundKey key1 = new CompoundKey(100, 10001);
		Accounts savings = new Accounts();
		savings.setCompoundKey(key1);
		savings.setAccountBalance(8500);
		
		
		CompoundKey key2 = new CompoundKey(100, 20001);
		Accounts checking = new Accounts();
		checking.setCompoundKey(key2);
		checking.setAccountBalance(2500);
		
		
		session.save(savings);
		session.save(checking);
		session.getTransaction().commit();
	}
}
