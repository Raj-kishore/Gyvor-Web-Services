package com.dynacult.restapi.controller;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dynacult.restapi.entity.Appuser;
import com.dynacult.restapi.service.UserService;

@RestController
@RequestMapping("/dynacult-apis")
public class applicationController {

	@Resource
	UserService userService;

	@GetMapping(value = "/usersList")
	public List<Appuser> getEmployees() {
		return userService.findAll();

	}

	@PostMapping(value = "/createUser")
	public void createEmployee(@RequestBody Appuser appuser) {
		userService.insertUser(appuser);

	}

	@PutMapping(value = "/updateUser")
	public void updateEmployee(@RequestBody Appuser appuser) {
		userService.updateUser(appuser);

	}

	@PutMapping(value = "/executeUpdateUser")
	public void executeUpdateEmployee(@RequestBody Appuser appuser) {
		userService.executeUpdateUser(appuser);

	}

	@DeleteMapping(value = "/deleteUserById")
	public void deleteEmployee(@RequestBody Appuser appuser) {
		userService.deleteUser(appuser);

	}

}
