package com.rays.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rays.dao.UserDAOHibImpl;
import com.rays.dao.UserDAOInt;
import com.rays.dao.UserDAOJDBCImpl;

@Configuration
public class DAOConfig {
	
	@Value(value = "hibernate")
	private String daoType;

	@Bean
	public UserDAOInt userDAO() {
		if ("jdbc".equalsIgnoreCase(daoType)) {
			return new UserDAOJDBCImpl();
		} else if ("hibernate".equalsIgnoreCase(daoType)) {
			return new UserDAOHibImpl();
		} else {
			throw new IllegalArgumentException("Invalid dao.type value: " + daoType);
		}
	}

}
