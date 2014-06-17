package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.BauteilDao;
import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.BauteilDs;
import bai5_hibernate.MPS_AE.hibernate.tables.Bauteil;

@Service
public class BauteilDsImpl extends GenericDsImpl<Bauteil> implements
		BauteilDs<Bauteil> {

	@Override
	protected IGenericDao<Bauteil> getDao() {
		return new BauteilDao();
	}
}
