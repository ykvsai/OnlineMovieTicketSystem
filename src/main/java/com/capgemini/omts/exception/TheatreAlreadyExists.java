package com.capgemini.omts.exception;

@SuppressWarnings("serial")
public class TheatreAlreadyExists extends Exception {
		
	public TheatreAlreadyExists() {
		super();
	}
		
	public TheatreAlreadyExists(String message) {
		super(message);
	}

}
