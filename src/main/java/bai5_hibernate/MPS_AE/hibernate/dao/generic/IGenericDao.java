package bai5_hibernate.MPS_AE.hibernate.dao.generic;

public interface IGenericDao<T> {

	public T findById(long id) throws Exception;

	public void add(T theObject) throws Exception;

	public void remove(T theObject) throws Exception;

	public T update(T objectToBeUpdated) throws Exception;
}
