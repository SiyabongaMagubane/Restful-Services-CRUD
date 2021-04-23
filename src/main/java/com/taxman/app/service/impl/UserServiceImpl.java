/**
 * 
 */
package com.taxman.app.service.impl;

import com.taxman.app.dao.DataAccessObject;
import com.taxman.app.dao.impl.DataAccessObjectImpl;
import com.taxman.app.service.UserService;
import com.taxman.app.shared.dto.UserDTO;
import com.taxman.app.ui.model.response.ErrorMessages;
import com.taxman.app.utils.UserProfileUtils;
import com.taxman.app.exceptions.*;

/**
 * @author siyabonga
 *
 */
public class UserServiceImpl implements UserService{
	DataAccessObject database;
	
	public UserServiceImpl() {
		this.database = new DataAccessObjectImpl();
	}
	
	UserProfileUtils userProfileUtils = new UserProfileUtils();

	@Override
	public UserDTO createUser(UserDTO user) {
		int sizeOfID = 30;
		
		UserDTO returnValue = new UserDTO();
		
		// validate if required fields are present
		userProfileUtils.validateRequiredFields(user);
		//check if user exists in DB
		UserDTO exisingUser = this.getUserByUsername(user.getEmail());
		
		if (exisingUser != null) {
			throw new UserAlreadyExistException(ErrorMessages.RECORD_ALREADY_EXISTS.name());
		}
		
		//Generate secure public userID
		String UserId = userProfileUtils.generateUserId(sizeOfID);
		user.setUserId(UserId);
		
		//Generate Salt for encrypted password
		String salt = userProfileUtils.getSalt(sizeOfID);
	
		//Generate encrypted password
		String PasswordEncryp = userProfileUtils.generateSecPass(user.getPassword(), salt);
		user.setSalt(salt);
		user.setEncryptedPass(PasswordEncryp);
		//Write data int DB
		
		returnValue = this.saveUser(user);
		
		return returnValue;
	}

	private UserDTO saveUser(UserDTO user) {
		
		UserDTO userCreated = null;
		try {
			this.database.openConnection();
			userCreated = this.database.saveUser(user);
		}
		finally {
			this.database.closeConnection();
		}
		return userCreated;
		
	}

	private UserDTO getUserByUsername(String username) {
		

		UserDTO userDto = null;
		
		if (username == null || username.isEmpty()) {
			return userDto;
		}
		//user exists
		
		try {
			this.database.openConnection();
			userDto = this.database.getUserNameByUsername(username);
		}
		finally {
			this.database.closeConnection();
		}
		return userDto;
		
		
	}

	@Override
	public UserDTO getUser(String id) {
			UserDTO userDto = null;
			try {
				this.database.openConnection();
				userDto = this.getUser(id);
				
			} catch(Exception e) {
				e.printStackTrace();
				throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
				
			}finally {
				this.database.closeConnection();
				
			}
			return userDto;
		}
	
	

}
