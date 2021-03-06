/**
 * 
 */
package com.taxman.app.ui.model.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 

 *
 */

@XmlRootElement
public class ErrorMessage {
	
	private String errorMessage;
	private String errorMessageKey;
	private String href;
	
	public ErrorMessage() {}
	
	public ErrorMessage(String errorMessage, String errorMessageKey,String href) {
		this.errorMessage = errorMessage;
		this.errorMessageKey = errorMessage;
		this.href = href;
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
	/**
	 * @return the errorMessageKey
	 */
	public String getErrorMessageKey() {
		return errorMessageKey;
	}
	/**
	 * @param errorMessageKey the errorMessageKey to set
	 */
	public void setErrorMessageKey(String errorMessageKey) {
		this.errorMessageKey = errorMessageKey;
	}
	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}
	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}
	

}
