package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.StuecklisteDao;
import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.StuecklisteDs;
import bai5_hibernate.MPS_AE.hibernate.tables.Stueckliste;

@Service
public class StuecklisteDsImpl extends GenericDsImpl<Stueckliste> implements
		StuecklisteDs<Stueckliste> {

	@Override
	protected IGenericDao<Stueckliste> getDao() {
		return new StuecklisteDao();
	}
}
