package bai5_hibernate.MPS_AE.hibernate.dao;

import org.springframework.stereotype.Repository;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Fertigungsauftrag;

@Repository
public class FertigungsauftragDao extends GenericDao<Fertigungsauftrag> {

	public FertigungsauftragDao() {
		super(Fertigungsauftrag.class);
	}

}
