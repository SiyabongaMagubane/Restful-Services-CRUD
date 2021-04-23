/**
 * 
 */
package com.taxman.app.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author siyabonga
 *
 */
public class HibernateUtils {
	private static final SessionFactory sessionFactory;
	static {
		Configuration conf = new Configuration();
		conf.configure();
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch(HibernateException e) {
			System.err.println("SessionFactory creation error "+ e + e.getCause());
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

}
