package com.dynacult.restapi.exception;

public class ResourceAlreadyExistsException extends Exception {
	 
    public ResourceAlreadyExistsException() {
    }
 
    public ResourceAlreadyExistsException(String msg) {
        super(msg);
    }
}