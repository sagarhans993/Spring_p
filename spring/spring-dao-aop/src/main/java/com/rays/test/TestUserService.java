package com.rays.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {
	
	
	public static ApplicationContext context = null;

	@Autowired
	public UserServiceInt service = null;

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

		// test.testFindByPk();
		test.testAdd();
		// test.testUpdate();
		// test.testSearch();
		// test.testAuth();
	}

	public void testSearch() {
		UserDTO dto = new UserDTO();
		System.out.println("service->" + service);
		List<UserDTO> l = service.search(dto, 1, 5);
		l.forEach(e -> {
			System.out.print(e.getId());
			System.out.print("\t" + e.getFirstname());
			System.out.print("\t" + e.getLastname());
			System.out.print("\t" + e.getLogin());
			System.out.println("\t" + e.getPassword());
		});
	}

	public void testAdd() {
		UserDTO dto = new UserDTO();
		// dto.setId(1);
		dto.setFirstname("ABC");
		dto.setLastname("ABC");
		dto.setLogin("ABC@gmail.com");
		dto.setPassword("pass1234");
		long pk = service.add(dto);
		System.out.println("PK->" + pk);
	}

	public void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstname("ABC");
		dto.setLastname("XYZ");
		dto.setLogin("ABC@gmail.com");
		dto.setPassword("pass1234");
		service.update(dto);
		System.out.println("Record updated");
	}

	public void testFindByPk() {
		UserDTO dto = service.findByPK(1);
		System.out.print(dto.getId());
		System.out.print("\t" + dto.getFirstname());
		System.out.print("\t" + dto.getLastname());
		System.out.print("\t" + dto.getLogin());
		System.out.println("\t" + dto.getPassword());
	}

	public void testAuth() {
		UserDTO dto = service.authenticate("ABC@gmail.com", "pass1234");
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstname());
			System.out.print("\t" + dto.getLastname());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("User not exist");
		}
	}


}
