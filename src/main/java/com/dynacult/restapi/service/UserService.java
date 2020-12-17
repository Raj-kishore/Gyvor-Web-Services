package com.dynacult.restapi.service;

import java.util.List;

import com.dynacult.restapi.entity.Appuser;

public interface UserService {
	List<Appuser> findAll();

	void insertUser(Appuser appuser);

	void updateUser(Appuser appuser);

	void executeUpdateUser(Appuser appuser);

	void deleteUser(Appuser appuser);
}
