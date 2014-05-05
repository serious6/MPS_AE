package bai5_hibernate.MPS_AE.hibernate.dao;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Fertigungsauftrag;

public class FertigungsauftragDao extends GenericDao<Fertigungsauftrag> {

	public FertigungsauftragDao() {
		super(Fertigungsauftrag.class);
	}

}
