package bai5_hibernate.MPS_AE.hibernate.dao;

import org.springframework.stereotype.Repository;

import bai5_hibernate.MPS_AE.hibernate.dao.generic.GenericDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Vorgang;

@Repository
public class VorgangDao extends GenericDao<Vorgang> {
	public VorgangDao() {
		super(Vorgang.class);
	}
}
