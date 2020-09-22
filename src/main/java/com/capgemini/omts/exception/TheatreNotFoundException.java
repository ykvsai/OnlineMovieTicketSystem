package com.capgemini.omts.exception;

@SuppressWarnings("serial")
public class TheatreNotFoundException extends Exception {
	
	public TheatreNotFoundException() {
		super();
	}
	
	public TheatreNotFoundException(String message) {
		super(message);
	}

}
