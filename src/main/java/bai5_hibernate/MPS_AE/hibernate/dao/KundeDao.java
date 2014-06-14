package bai5_hibernate.MPS_AE.hibernate.dao;

import org.springframework.stereotype.Repository;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Kunde;

@Repository
public class KundeDao extends GenericDao<Kunde> {

	public KundeDao() {
		super(Kunde.class);
	}

}
