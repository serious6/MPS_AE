package bai5_hibernate.MPS_AE.hibernate.dao;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Rechnung;

public class RechnungDao extends GenericDao<Rechnung> {

	public RechnungDao() {
		super(Rechnung.class);
	}

}
