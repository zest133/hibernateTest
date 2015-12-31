package com.zest.jpa.manytomanyextracolumn;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zest.jpa.manytomanyextracolumn.repository.PersonRepository;
import com.zest.jpa.manytomanyextracolumn.repository.ProjectRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jpa-context.xml")
public class ProjectTest {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private EntityManagerFactory emf;

	// @Test
	// public void projectMake(){
	// // Person person = new Person("gno1", "gnogun@naver.com1", "gno1");
	// Project project = new Project("project122222", "description");
	// // ArrayList<Person> list = new ArrayList<Person>();
	// // list.add(person);
	// // projectRepository.save(new Project("project1", "description", list));
	// projectRepository.save(project);
	// }

//	@Test
//	public void projectMakeEx() {
//		Person person = new Person("gno2222222", "gnogun@naver.com", "gno");
//
//		personRepository.save(person);
//
//		for (int i = 0; i < 10; i++) {
//
//			Project project = new Project("projec" + i, "description");
//			Group group = new Group(person, project, "owner");
//			project.getGroups().add(group);
//			projectRepository.save(project);
//			
//			
//			
//			
//		}
//		
//		
//
//	}

//	@Test
//	public void jpqlTest() {
//		Person person = new Person("gno2222222", "gnogun@naver.com", "gno");
//
//		personRepository.save(person);
//
//		for (int i = 0; i < 10; i++) {
//
//			Project project = new Project("projec" + i, "description");
//			Group group = new Group(person, project, "owner");
//			project.getGroups().add(group);
//			projectRepository.save(project);
//		}
//
//		EntityManager entitymanager = emf.createEntityManager();
//		Query query = entitymanager
//				.createQuery("Select e.role from project_groups e");
//		List<String> list = query.getResultList();
//		for (String e : list) {
//			System.out.println("Employee NAME :" + e);
//		}
//	}
	@Test
	public void joinTest(){
//		Person person = new Person("gno2222222", "gnogun@naver.com", "gno");
//
//		personRepository.save(person);
//
//		for (int i = 0; i < 10; i++) {
//
//			Project project = new Project("projec" + i, "description");
//			Group group = new Group(person, project, "owner");
//			project.getGroups().add(group);
//			projectRepository.save(project);
//			
//		}
		
		GroupID id = new GroupID();
		id.setProject(12);
		id.setPerson(2);
		EntityManager entitymanager = emf.createEntityManager();
		Group group = entitymanager.find(Group.class, id);
		System.out.println(group);
	}

}
