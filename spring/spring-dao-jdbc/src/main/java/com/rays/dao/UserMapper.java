package com.rays.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rays.dto.UserDTO;

public class UserMapper implements RowMapper<UserDTO> {

	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserDTO user = new UserDTO();

		user.setId(rs.getLong(1));
		user.setFristname(rs.getString(2));
		user.setLastname(rs.getString(3));
		user.setLoginid(rs.getString(4));
		user.setPassword(rs.getString(5));
		return user;
	}

}
