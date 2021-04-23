/**
 * 
 */
package com.taxman.app.exceptions;

/**
 * @author siyabonga
 *
 */
public class NoRecordFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7982565679237250504L;

	public NoRecordFoundException(String message) {
		super(message);
	}

}
