package bai5_hibernate.MPS_AE.hibernate.dao;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Arbeitsplan;

public class ArbeitsplanDao extends GenericDao<Arbeitsplan> {

	public ArbeitsplanDao() {
		super(Arbeitsplan.class);
	}

}
