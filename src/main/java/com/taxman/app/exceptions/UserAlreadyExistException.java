/**
 * 
 */
package com.taxman.app.exceptions;


/**
 * @author siyabonga
 *
 */

public class UserAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6459411486836160973L;

	
	public UserAlreadyExistException( String message ) {
		super(message);
	}
	
	

}
