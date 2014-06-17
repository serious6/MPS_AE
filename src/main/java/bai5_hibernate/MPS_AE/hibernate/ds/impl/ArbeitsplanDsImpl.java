package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.ArbeitsplanDao;
import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.ArbeitsplanDs;
import bai5_hibernate.MPS_AE.hibernate.tables.Arbeitsplan;

@Service
public class ArbeitsplanDsImpl extends GenericDsImpl<Arbeitsplan> implements
		ArbeitsplanDs<Arbeitsplan> {

	@Override
	protected IGenericDao<Arbeitsplan> getDao() {
		// TODO Auto-generated method stub
		return new ArbeitsplanDao();
	}
}
