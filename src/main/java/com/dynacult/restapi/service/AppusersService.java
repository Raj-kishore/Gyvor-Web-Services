package com.dynacult.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.dynacult.restapi.entity.Appuser;
import com.dynacult.restapi.exception.BadResourceException;
import com.dynacult.restapi.exception.ResourceAlreadyExistsException;
import com.dynacult.restapi.repository.AppusersDAO;
import java.util.ArrayList;
import java.util.List;

import java.util.Collections;
@Service
public class AppusersService {

	@Autowired
	private AppusersDAO appusersDAO;

	private boolean existsById(Long id) {
		return appusersDAO.existsById(id);
	}

	public List<Appuser> findAll() {
		List<Appuser> appusers = new ArrayList<>();
		appusersDAO.findAll().forEach(appuser -> appusers.add(appuser));
		 Collections.sort(appusers, (appuser1,appuser2)->appuser1.getUserId()>appuser2.getUserId()?-1:0);
		return appusers;
	}

	public Appuser save(Appuser appuser) throws BadResourceException, ResourceAlreadyExistsException {
		if (!StringUtils.isEmpty(appuser.getUserMobileNo()) || !StringUtils.isEmpty(appuser.getUserEmail())) {
			if (appuser.getUserId() != null && existsById(appuser.getUserId())) {
				throw new ResourceAlreadyExistsException(
						"App user with id: " + appuser.getUserId() + " already exists");
			}
			return appusersDAO.save(appuser);
		} else {
			BadResourceException exc = new BadResourceException("Failed to save appuser");
			exc.addErrorMessage("Appuser is null or empty");
			throw exc;
		}
	}

}
