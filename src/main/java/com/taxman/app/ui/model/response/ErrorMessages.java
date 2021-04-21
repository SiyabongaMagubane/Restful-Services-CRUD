/**
 * 
 */
package com.taxman.app.ui.model.response;

/**
 * @author siyabonga
 *
 */
public enum ErrorMessages {
	
	MISSING_REQUIRED_FIELD("Missing required field, please check documentation for required fields")
	,RECORD_ALREADY_EXISTS("Record already exists"),
	INTERNL_SERVER_ERROR("`Internal server error");
	
	private String errorMessage;
	ErrorMessages(String errorMessage){
		this.errorMessage = (errorMessage);
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
