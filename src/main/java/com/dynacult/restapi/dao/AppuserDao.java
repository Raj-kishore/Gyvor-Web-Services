package com.dynacult.restapi.dao;

import java.util.List;

import com.dynacult.restapi.entity.Appuser;

public interface AppuserDao {

	List<Appuser> findAll();

	void insertUser(Appuser appuser);

	void updateUser(Appuser appuser);

	void executeUpdateUser(Appuser appuser);

	public void deleteUser(Appuser appuser);
}
