package com.dynacult.restapi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dynacult.restapi.entity.Appuser;

public class AppuserRowMapper implements RowMapper<Appuser> {

	@Override
	public Appuser mapRow(ResultSet rs, int rowNum) throws SQLException {
		Appuser appuser = new Appuser();
		appuser.setUserId(rs.getString("userId"));
		appuser.setUserName(rs.getString("userName"));
		appuser.setUserMobileNo(rs.getString("userMobileNo"));
		appuser.setUserEmail(rs.getString("userEmail"));
		
		return appuser;
	}

}
