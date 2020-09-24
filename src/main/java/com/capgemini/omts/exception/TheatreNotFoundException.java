package com.capgemini.omts.exception;

/*************************************************************************************************************************
 * @author Yakkala Kesava Venkata Sai
 * @since 21-September-2020
 * @Description: It is a user defined Exception class for Theatre module in
 *               Online Movie Ticket System
 *************************************************************************************************************************/
@SuppressWarnings("serial")
public class TheatreNotFoundException extends Exception {

	public TheatreNotFoundException() {
		super();
	}

	public TheatreNotFoundException(String message) {
		super(message);
	}

}
