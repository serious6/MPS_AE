package bai5_hibernate.MPS_AE.hibernate.dao;

import org.springframework.stereotype.Repository;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Auftrag;

@Repository
public class AuftragDao extends GenericDao<Auftrag> {

	public AuftragDao() {
		super(Auftrag.class);
	}

}
