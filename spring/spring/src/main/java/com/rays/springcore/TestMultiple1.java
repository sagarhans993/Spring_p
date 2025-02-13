package com.rays.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultiple1 {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"UserBean.xml", "Person.xml" });

		
		UserBean bean=(UserBean) context.getBean("UserBean");
		System.out.println(bean.getLogin());
		System.out.println(bean.getPassword());
		
		Person person=(Person) context.getBean("Person");
		System.out.println(person.getName());
	}

}
