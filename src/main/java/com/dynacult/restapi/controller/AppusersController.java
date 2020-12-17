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
import com.dynacult.restapi.exception.BadResourceException;
import com.dynacult.restapi.exception.ResourceAlreadyExistsException;
import com.dynacult.restapi.response.APIResponse;
import com.dynacult.restapi.service.AppusersService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppusersController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AppusersService appusersService;

	@GetMapping(value = "/appusers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Appuser>> findAllappusers() {
		return ResponseEntity.ok(appusersService.findAll());
	}

	@PostMapping(value = "/appuser")
	public ResponseEntity<Appuser> addAppuser(@Valid @RequestBody Appuser appuser) throws URISyntaxException {
		try {
			Appuser newContact = appusersService.save(appuser);
			return ResponseEntity.created(new URI("/api/appusers/" + newContact.getUserId())).body(appuser);
		} catch (ResourceAlreadyExistsException ex) {
			// log exception first, then return Conflict (409)
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (BadResourceException ex) {
			// log exception first, then return Bad Request (400)
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
