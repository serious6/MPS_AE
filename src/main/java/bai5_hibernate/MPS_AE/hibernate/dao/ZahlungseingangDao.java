package bai5_hibernate.MPS_AE.hibernate.dao;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Zahlungseingang;

public class ZahlungseingangDao extends GenericDao<Zahlungseingang> {

	public ZahlungseingangDao() {
		super(Zahlungseingang.class);
	}

}
