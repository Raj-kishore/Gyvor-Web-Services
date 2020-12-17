package com.dynacult.restapi.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dynacult.restapi.dao.AppuserDao;
import com.dynacult.restapi.entity.Appuser;

@Component
public class UserServiceImpl implements UserService {

	@Resource
	AppuserDao appuserDao;

	@Override
	public List<Appuser> findAll() {
		return appuserDao.findAll();
	}

	@Override
	public void insertUser(Appuser appuser) {
		appuserDao.insertUser(appuser);
	}

	@Override
	public void updateUser(Appuser appuser) {
		appuserDao.updateUser(appuser);

	}

	@Override
	public void executeUpdateUser(Appuser appuser) {
		appuserDao.executeUpdateUser(appuser);

	}

	@Override
	public void deleteUser(Appuser appuser) {
		appuserDao.deleteUser(appuser);

	}

}
