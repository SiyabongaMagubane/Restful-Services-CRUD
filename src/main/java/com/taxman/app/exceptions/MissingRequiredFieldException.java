/**
 * 
 */
package com.taxman.app.exceptions;

/**
 * @author siyabonga
 *
 */
public class MissingRequiredFieldException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	public MissingRequiredFieldException( String message ) {
		super(message);
	}
	

}
