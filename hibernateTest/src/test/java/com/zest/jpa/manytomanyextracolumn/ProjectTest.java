package com.zest.jpa.manytomanyextracolumn;

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
	
	@Test
	public void projectMake(){
//		Person person = new Person("gno1", "gnogun@naver.com1", "gno1");
		Project project = new Project("project122222", "description");
//		ArrayList<Person> list = new ArrayList<Person>();
//		list.add(person);
//		projectRepository.save(new Project("project1", "description", list));
		projectRepository.save(project);
	}
	
	@Test
	public void projectMakeEx(){
		Person person = new Person("gno2222222", "gnogun@naver.com", "gno");
		Project project = new Project("project122222", "description");
		
		Group group = new Group(person, project, "owner");
		
		
		project.getGroups().add(group);
		
		personRepository.save(person);
		
		projectRepository.save(project);
		
		
	}
}
