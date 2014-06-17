package bai5_hibernate.MPS_AE.hibernate.dao;

import org.springframework.stereotype.Repository;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Bauteil;

@Repository
public class BauteilDao extends GenericDao<Bauteil> {
	public BauteilDao() {
		super(Bauteil.class);
	}
}
