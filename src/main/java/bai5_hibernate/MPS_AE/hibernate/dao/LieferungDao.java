package bai5_hibernate.MPS_AE.hibernate.dao;

import org.springframework.stereotype.Repository;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Lieferung;

@Repository
public class LieferungDao extends GenericDao<Lieferung> {

	public LieferungDao() {
		super(Lieferung.class);
	}

}
