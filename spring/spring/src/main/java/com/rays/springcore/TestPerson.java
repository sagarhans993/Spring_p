package com.rays.springcore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestPerson {
	public static void main(String[] args) {
		
		BeanFactory  factory =new XmlBeanFactory(new ClassPathResource("Person.xml"));
		
		Person person=(Person) factory.getBean("Person");
		
		System.out.println(person.getName());

	}

}
