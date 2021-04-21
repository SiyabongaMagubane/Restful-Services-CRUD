/**
 * 
 */
package com.taxman.app.exceptions;


import com.taxman.app.ui.model.response.ErrorMessage;
import com.taxman.app.ui.model.response.ErrorMessages;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author siyabonga
 *
 */

@Provider
public class MissingRequiredFieldExceptionMapper implements ExceptionMapper<MissingRequiredFieldException> {


	public Response toResponse(MissingRequiredFieldException exception) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), ErrorMessages.MISSING_REQUIRED_FIELD.name(), "https://github.com/SiyabongaMagubane/Restful-Services-CRUD/edit/main/README.md");
		return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
	}

}
