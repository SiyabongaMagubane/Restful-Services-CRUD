/**
 * 
 */
package com.taxman.app.dao.impl;

import java.util.List;


//import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.springframework.beans.BeanUtils;

import com.taxman.app.dao.DataAccessObject;
import com.taxman.app.io.entity.*;
import com.taxman.app.shared.dto.UserDTO;
import com.taxman.app.utils.HibernateUtils;




/**
 * @author siyabonga
 *z
 */
public class DataAccessObjectImpl implements DataAccessObject {
	
	Session session;

	@Override
	public void openConnection() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		
	}

	@Override
	public UserDTO getUserNameByUsername(String username) {
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		//Criteria against persistent class
		CriteriaQuery<UserEntity> criteria = cb.createQuery(UserEntity.class);
		
		
		//Query roots 
		Root<UserEntity> profileRoot = criteria.from(UserEntity.class);
		criteria.select(profileRoot);
		criteria.where(cb.equal(profileRoot.get("email"), username));
		
		
		//Fetch singe result
		
		UserDTO userDto = null;
		Query<UserEntity> query = session.createQuery(criteria);
		List<UserEntity> resultUsers = query.getResultList();
		if( resultUsers.size() > 0 && resultUsers != null ) {
			// user succesfully queried.
			
			UserEntity userEntity = resultUsers.get(0);
			userDto = new UserDTO();
			BeanUtils.copyProperties(userEntity, userDto);	
		}	
		return userDto;
	}

	@Override
	public void closeConnection() {
		if (session != null) {
			session.close();
		}
	}

	@Override
	public UserDTO saveUser(UserDTO user) {
		
		UserDTO userDto = new UserDTO();
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		session.beginTransaction();
		session.save(userEntity);
		session.getTransaction().commit();
		
		BeanUtils.copyProperties(userEntity, userDto);
		
		// TODO Auto-generated method stub
		return userDto;
	}

}
