package bai5_hibernate.MPS_AE.hibernate.dao;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Auftrag;

public class AuftragDao extends GenericDao<Auftrag> {

	public AuftragDao() {
		super(Auftrag.class);
	}

}
