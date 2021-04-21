/**
 * 
 */
package com.taxman.app.exceptions;

/**
 * @author siyabonga
 *
 */
import com.taxman.app.ui.model.response.ErrorMessage;
import com.taxman.app.ui.model.response.ErrorMessages;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserAlreadyExistExceptionMapper implements ExceptionMapper<UserAlreadyExistException>{

	@Override
	public Response toResponse(UserAlreadyExistException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), ErrorMessages.RECORD_ALREADY_EXISTS.name(), "https://github.com/SiyabongaMagubane/Restful-Services-CRUD/edit/main/README.md");
		return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
	}

}
