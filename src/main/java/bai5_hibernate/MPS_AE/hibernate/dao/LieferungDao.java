package bai5_hibernate.MPS_AE.hibernate.dao;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Lieferung;

public class LieferungDao extends GenericDao<Lieferung> {

	public LieferungDao() {
		super(Lieferung.class);
	}

}
