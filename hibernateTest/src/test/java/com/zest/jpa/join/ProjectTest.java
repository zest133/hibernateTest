package com.zest.jpa.join;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jpa-context.xml")
public class ProjectTest {

//	@Autowired
//	private ProjectRepository projectRepository;
//
//	@Autowired
//	private PersonRepository personRepository;

	@PersistenceContext(unitName="educationPU")
	private EntityManager em;

	
	
	@Test
	public void test1(){
		
		
		
		
//		EntityManager em = emf.createEntityManager();
		Employee emp = new Employee("pune",1,"Prasad","Kharkar", 100000);
		em.persist(emp);
//		EmployeeId id = new EmployeeId("pune", 1);
////		Employee emp = em.find(Employee.class, id);
//		System.out.println("First name = " + emp.getFirstName() + " "
//			+ "Last Name = " + emp.getLastName() + " " + "salary = "
//			+ emp.getSalary());
	}

}
