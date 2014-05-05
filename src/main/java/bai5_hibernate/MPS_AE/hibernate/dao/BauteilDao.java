package bai5_hibernate.MPS_AE.hibernate.dao;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Bauteil;

public class BauteilDao extends GenericDao<Bauteil> {

	public BauteilDao() {
		super(Bauteil.class);
	}

}
