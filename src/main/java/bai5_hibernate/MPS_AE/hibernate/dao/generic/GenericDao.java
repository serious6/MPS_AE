package bai5_hibernate.MPS_AE.hibernate.dao.generic;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import bai5_hibernate.MPS_AE.hibernate.utils.SessionFactoryBuilder;

@Repository
public class GenericDao<T extends Serializable> implements IGenericDao<T> {

	private final Class<T> typeParameterClass;

	public GenericDao(Class<T> typeParameterClass) {
		super();
		assert typeParameterClass != null;

		this.typeParameterClass = typeParameterClass;
	}

	public void add(T theObject) throws Exception {
		Session session = null;
		try {
			assert theObject != null;

			session = getTransaction();
			session.save(theObject);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public T findById(long id) throws Exception {
		assert id > 0;

		Session session = null;
		try {

			session = getTransaction();
			Object result = session.get(typeParameterClass, id);
			session.getTransaction().commit();
			return (result != null ? (T) result : null);
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void remove(T theObject) throws Exception {
		assert theObject != null;

		Session session = null;
		try {

			session = getTransaction();
			session.delete(theObject);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public T update(T objectToBeUpdated) throws Exception {
		assert objectToBeUpdated != null;

		Session session = null;
		try {

			session = getTransaction();
			session.merge(objectToBeUpdated);

			session.getTransaction().commit();
			return objectToBeUpdated;
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Gets the Session and begins a Transaction.
	 * 
	 * @return the transaction
	 * @throws Exception
	 * @throws HibernateException
	 */
	protected Session getTransaction() throws HibernateException, Exception {
		Session session = SessionFactoryBuilder.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return session;
	}

}
