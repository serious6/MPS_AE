package bai5_hibernate.MPS_AE.hibernate.dao;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Vorgang;

public class VorgangDao extends GenericDao<Vorgang> {

	public VorgangDao() {
		super(Vorgang.class);
	}

}
