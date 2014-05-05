package bai5_hibernate.MPS_AE.hibernate.dao;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Kunde;

public class KundeDao extends GenericDao<Kunde> {

	public KundeDao() {
		super(Kunde.class);
	}

}
