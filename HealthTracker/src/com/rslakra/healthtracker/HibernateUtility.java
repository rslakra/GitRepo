/**
 * 
 */
package com.rslakra.healthtracker;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author lakra
 *
 */
public final class HibernateUtility {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private HibernateUtility() {

	}

	/**
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			synchronized (HibernateUtility.class) {
				if (sessionFactory == null) {
					Configuration config = new Configuration().configure();
//					serviceRegistry = new ServiceRegistryBuilder();
				}
			}
		}

		return sessionFactory;
	}

}
