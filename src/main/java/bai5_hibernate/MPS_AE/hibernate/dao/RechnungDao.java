package bai5_hibernate.MPS_AE.hibernate.dao;

import org.springframework.stereotype.Repository;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Rechnung;

@Repository
public class RechnungDao extends GenericDao<Rechnung> {

	public RechnungDao() {
		super(Rechnung.class);
	}

}
