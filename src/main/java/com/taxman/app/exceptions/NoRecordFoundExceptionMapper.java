/**
 * 
 */
package com.taxman.app.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.taxman.app.ui.model.response.ErrorMessage;
import com.taxman.app.ui.model.response.ErrorMessages;

/**
 * @author siyabonga
 *
 */
@Provider
public class NoRecordFoundExceptionMapper implements ExceptionMapper<NoRecordFoundException>{

	@Override
	public Response toResponse(NoRecordFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), ErrorMessages.NO_RECORD_FOUND.name(), "https://github.com/SiyabongaMagubane/Restful-Services-CRUD/edit/main/README.md");
		return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
		
	}
	

}
