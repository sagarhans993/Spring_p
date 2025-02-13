package com.rays.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")

public class TestUserService {

	
 		@Autowired
 		
		public UserServiceInt service = null;

		public static void main(String[] args) throws Exception {

			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

			TestUserService test = (TestUserService) context.getBean("testUserService");

			// test.testAdd();
			 //test.testUpdate();
			// test.testDelete();
			 test.testFindByPk();
			// test.testAuth();
			//test.testSearch();

		}

		public void testAdd() {
			UserDTO dto = new UserDTO();
			dto.setId(2);
			dto.setLastname("xyz");
			dto.setFristname("xyz");
			dto.setLoginid("admin1");
			dto.setPassword("pass1234");
			long pk = service.add(dto);
			System.out.println("Data Inserted... pk = " + pk);
		}

		public void testUpdate() {
			UserDTO dto = new UserDTO();
			dto.setId(1);
			dto.setLastname("ABC");
			dto.setFristname("sagar");
			dto.setLoginid("ABC@gmail.com");
			dto.setPassword("pass1234");
			service.update(dto);
			System.out.println("Data updated");
		}

		private void testDelete() {
			service.delete(2L);
			System.out.println("data Deleted!!!!!");
		}

		public void testFindByPk() {
			UserDTO dto = service.findByPK(1);
			if (dto != null) {
				System.out.print(dto.getId());
				System.out.print("\t" + dto.getFristname());
				System.out.print("\t" + dto.getLastname());
				System.out.print("\t" + dto.getLoginid());
				System.out.println("\t" + dto.getPassword());
			} else {
				System.out.println("User ID not exist..!!!");
			}
		}

		public void testAuth() {
			UserDTO dto = service.authenticate("ABC@gmail.com", "pass1234");
			if (dto != null) {
				System.out.print(dto.getId());
				System.out.print("\t" + dto.getFristname());
				System.out.print("\t" + dto.getLastname());
				System.out.print("\t" + dto.getLoginid());
				System.out.println("\t" + dto.getPassword());
			} else {
				System.out.println("User not exist");
			}
		}

		public void testSearch() {

			UserDTO dto = new UserDTO();

			List<UserDTO> list = service.search(dto, 0, 5);

			Iterator it = list.iterator();

			while (it.hasNext()) {
				dto = (UserDTO) it.next();
				System.out.print(dto.getId());
				System.out.print("\t" + dto.getFristname());
				System.out.print("\t" + dto.getLastname());
				System.out.print("\t" + dto.getLoginid());
				System.out.println("\t" + dto.getPassword());
			}
		
	}
}
