/**
 * 
 */
package com.taxman.app.dao;

import com.taxman.app.shared.dto.UserDTO;

/**
 * @author siyabonga
 *
 */
public interface DataAccessObject {
	public void openConnection();
	public UserDTO getUserNameByUsername(String username);
	public void closeConnection();
	public UserDTO saveUser(UserDTO user);
	public UserDTO getUser(String id);
}
