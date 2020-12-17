package com.dynacult.restapi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.dynacult.restapi.entity.Appuser;
import com.dynacult.restapi.mapper.AppuserRowMapper;

@Repository
public class AppuserDaoImpl implements AppuserDao {

	NamedParameterJdbcTemplate template;

	public AppuserDaoImpl(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Appuser> findAll() {
		return template.query("select * from appusers", new AppuserRowMapper());
	}

	@Override
	public void insertUser(Appuser appuser) {

		final String sql = "insert into appusers(UserId, UserName , UserMobileNo ,UserEmail) values(:UserId,:UserName,:UserMobileNo,:UserEmail)";

		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource().addValue("UserId", appuser.getUserId())
				.addValue("UserName", appuser.getUserName()).addValue("UserEmail", appuser.getUserEmail())
				.addValue("UserMobileNo", appuser.getUserMobileNo());
		template.update(sql, param, holder);

	}

	@Override
	public void updateUser(Appuser appuser) {
		final String sql = "update appusers set UserName=:UserName, UserMobileNo=:UserMobileNo, UserEmail=:UserEmail where UserId=:UserId";
		
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource().addValue("UserId", appuser.getUserId())
				.addValue("UserName", appuser.getUserName()).addValue("UserEmail", appuser.getUserEmail())
				.addValue("UserMobileNo", appuser.getUserMobileNo());
		template.update(sql, param, holder);

	}

	@Override
	public void executeUpdateUser(Appuser appuser) {

		final String sql = "update appusers set UserName=:UserName, UserMobileNo=:UserMobileNo, UserEmail=:UserEmail where UserId=:UserId";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("UserId", appuser.getUserId());
		map.put("UserName", appuser.getUserName());
		map.put("UserEmail", appuser.getUserEmail());
		map.put("UserMobileNo", appuser.getUserMobileNo());
		
		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});

	}

	@Override
	public void deleteUser(Appuser appuser) {

		final String sql = "delete from appusers where UserId=:UserId";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("UserId", appuser.getUserId());

		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});

	}

}
