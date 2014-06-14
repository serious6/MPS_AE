package bai5_hibernate.MPS_AE.hibernate.dao;

import org.springframework.stereotype.Repository;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Stueckliste;

@Repository
public class StuecklisteDao extends GenericDao<Stueckliste> {

	public StuecklisteDao() {
		super(Stueckliste.class);
	}

}
