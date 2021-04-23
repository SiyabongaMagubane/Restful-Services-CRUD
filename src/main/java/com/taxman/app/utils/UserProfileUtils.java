/**
 * 
 */
package com.taxman.app.utils;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.taxman.app.exceptions.MissingRequiredFieldException;
import com.taxman.app.shared.dto.UserDTO;
import com.taxman.app.ui.model.response.ErrorMessages;

/**
 * @author siyabonga
 *
 */
public class UserProfileUtils {
	
	
	private static final int ITERATIONS = 15000;
	private static final int KEY_LENGTH = 256;
	private final Random Arbitary = new SecureRandom();
	private final String Alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWZYZ";
	
	private String generateRandomString( int size) {
		StringBuilder randomString = new StringBuilder(size);
		int i = 0;
		while (i < size) {
			randomString.append(Alphabet.charAt(Arbitary.nextInt(Alphabet.length())));
			i++;
		}
		return new String (randomString);
	}
	
	public String generateUserId(int size) {
		return generateRandomString(size);
	}
	
	public String getSalt(int size) {
		return generateRandomString(size);
	}
	
	public String generateSecPass(String password, String salt) {
		String SecPass;
		
		byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
		SecPass = Base64.getEncoder().encodeToString(securePassword);
		return SecPass;
	}
	
	
	public byte[] hash(char[] password, byte[] salt) {
		KeySpec spec = new PBEKeySpec(password,salt, ITERATIONS,KEY_LENGTH);
		Arrays.fill(password, Character.MIN_VALUE);
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return factory.generateSecret(spec).getEncoded();
		}
		catch(Exception e) {
			throw new AssertionError("Error in hasing password function "+e.getMessage());
		}
		
	}

	public void validateRequiredFields(UserDTO userDto ) throws MissingRequiredFieldException
	{
		if ( userDto.getFirstname() == null ||
				userDto.getFirstname().isEmpty() ||
				userDto.getLastname() == null ||
				userDto.getLastname().isEmpty() ||
				userDto.getPassword() == null ||
				userDto.getPassword().isEmpty() ||
				userDto.getEmail() == null ||
				userDto.getEmail().isEmpty()) {
			throw new MissingRequiredFieldException(
					ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
			
		}
				
				
				
				
				
				
				
				
			
			
		
	}
}
