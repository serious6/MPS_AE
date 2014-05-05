package bai5_hibernate.MPS_AE.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * A builder for creating SessionFactory objects.
 */
public class SessionFactoryBuilder {

	private static SessionFactory sessionFactory;

	private SessionFactoryBuilder() {
		// singleton
	}

	/**
	 * Builds the session factory.
	 * 
	 * @return the session factory
	 * @throws Exception
	 */
	private static SessionFactory buildSessionFactory() throws Exception {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			return configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Gets the session factory.
	 * 
	 * @return the session factory
	 * @throws Exception
	 */
	public static synchronized SessionFactory getSessionFactory()
			throws Exception {
		if (sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}
}
