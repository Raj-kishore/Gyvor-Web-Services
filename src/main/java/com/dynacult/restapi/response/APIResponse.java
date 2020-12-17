package com.dynacult.restapi.response;


import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.dynacult.restapi.exception.ValidationError;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Data
@JsonInclude(Include.NON_NULL)
public class APIResponse {
	
	@Autowired
	private boolean success=true;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private final LocalDateTime timestamp=LocalDateTime.now();
	
	@Autowired
	private final String message;
	private Object returnValue;
	private Set<ValidationError> errorDetails;
	private String jwtToken;
	
//	public void logResponse() {
//		log.debug(toString());
//	}

	public APIResponse(Set<ValidationError> list, String message) {
		this.message = message;
		this.errorDetails = list;
		this.success=false;
	}

	public APIResponse(Object object, String msg) {
		this.returnValue = object;
		this.message = msg;
	}
	
	public APIResponse(Object object, String msg,String jwtToken) {
		this.returnValue = object;
		this.message = msg;
		this.jwtToken=jwtToken;
	}
	
}

