package bai5_hibernate.MPS_AE.hibernate.dao;

import org.springframework.stereotype.Repository;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Transportauftrag;

@Repository
public class TransportauftragDao extends GenericDao<Transportauftrag> {
	public TransportauftragDao() {
		super(Transportauftrag.class);
	}
}
