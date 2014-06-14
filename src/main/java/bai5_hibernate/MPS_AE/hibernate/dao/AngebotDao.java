package bai5_hibernate.MPS_AE.hibernate.dao;

import org.springframework.stereotype.Repository;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Angebot;

@Repository
public class AngebotDao extends GenericDao<Angebot> {

	public AngebotDao() {
		super(Angebot.class);
	}

}
