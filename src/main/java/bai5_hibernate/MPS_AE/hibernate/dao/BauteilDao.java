package bai5_hibernate.MPS_AE.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Bauteil;

public class BauteilDao extends GenericDao<Bauteil> {

	public BauteilDao() {
		super(Bauteil.class);
	}

	public boolean isComplex(Bauteil bauteil) {
		assert bauteil != null;

		Session session;
		try {
			session = getTransaction();

			Criteria criteria = session.createCriteria(Bauteil.class)
					.add(Restrictions.idEq(bauteil.getNummer()))
					.add(Restrictions.isNotNull("stueckliste"));
			List<Bauteil> result = criteria.list();

			session.getTransaction().commit();
			return result.size() > 0;
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
