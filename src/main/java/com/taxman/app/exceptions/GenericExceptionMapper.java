package com.taxman.app.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.taxman.app.ui.model.response.ErrorMessage;
import com.taxman.app.ui.model.response.ErrorMessages;



@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		// TODO Auto-generated method stub
				ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), ErrorMessages.INTERNL_SERVER_ERROR.name(), "https://github.com/SiyabongaMagubane/Restful-Services-CRUD/edit/main/README.md");
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}
	

}
