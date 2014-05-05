package bai5_hibernate.MPS_AE.hibernate.dao;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Angebot;

public class AngebotDao extends GenericDao<Angebot> {

	public AngebotDao() {
		super(Angebot.class);
	}

}
