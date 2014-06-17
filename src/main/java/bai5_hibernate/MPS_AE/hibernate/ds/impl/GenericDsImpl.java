package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.GenericDs;

public abstract class GenericDsImpl<T> implements GenericDs<T> {

	protected abstract IGenericDao<T> getDao();

	public T findById(long id) throws Exception {
		return getDao().findById(id);
	}

	public void add(T theObject) throws Exception {
		getDao().add(theObject);
	}

	public void remove(T theObject) throws Exception {
		getDao().remove(theObject);
	}

	public T update(T objectToBeUpdated) throws Exception {
		return getDao().update(objectToBeUpdated);
	}

}
