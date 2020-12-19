package com.dynacult.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.util.*; 
import com.dynacult.restapi.entity.Appuser;
import com.dynacult.restapi.exception.BadResourceException;
import com.dynacult.restapi.exception.ResourceAlreadyExistsException;
import com.dynacult.restapi.repository.AppusersDAO;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
public class AppusersService  implements UserDetailsService {

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
	
	@Override
	public UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException {
		List<Appuser> usersArray = this.findAll();

        Boolean isExist = checkUserIfExist(usersArray, phoneNo);
		
		if (isExist) {
			return new User(phoneNo, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with phone number: " + phoneNo);
		}
	}
	public Boolean checkUserIfExist(List<Appuser> usersArray, String wantedPhoneNo) {
		Boolean isUserExist = false; 
		for ( Appuser user : usersArray){
		    if (wantedPhoneNo.equals(user.getUserMobileNo())){
		        isUserExist = true; 
		        break;
		    }
		}
		return isUserExist;
	}

}
