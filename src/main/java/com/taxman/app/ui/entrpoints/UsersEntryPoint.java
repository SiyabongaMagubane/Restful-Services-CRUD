/**
 * 
 */
package com.taxman.app.ui.entrpoints;

import org.springframework.beans.BeanUtils;

import com.taxman.app.service.UserService;
import com.taxman.app.service.impl.UserServiceImpl;
import com.taxman.app.shared.dto.UserDTO;
import com.taxman.app.ui.model.request.CreateUserRequestModel;
import com.taxman.app.ui.model.response.CreateUserResponseModel;

//import org.eclipse.persistence.oxm.MediaType;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




/**
 * @author siyabonga
 *
 */

@Path("/users")
public class UsersEntryPoint {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public CreateUserResponseModel createUser(CreateUserRequestModel requestObject) {
		CreateUserResponseModel objectReturned = new CreateUserResponseModel();
		
		//prepare DTO user from Request
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(requestObject, userDTO);
		
		//Creating new user
		UserService userService = new UserServiceImpl();
		UserDTO createdUserProfile = userService.createUser(userDTO);
		
		
		//Prepare response
		BeanUtils.copyProperties(createdUserProfile, objectReturned);
		
		return objectReturned;
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public CreateUserResponseModel getUser(@PathParam("id") String id) {
		
CreateUserResponseModel objectReturned = new CreateUserResponseModel();
		
		//query user
		UserService userService = new UserServiceImpl();
		UserDTO receivedUserProfile = userService.getUser(id);
		//Prepare response
		BeanUtils.copyProperties(receivedUserProfile, objectReturned);
		
		return objectReturned;
		
	}
	
}
