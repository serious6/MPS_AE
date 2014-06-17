package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.RechnungDao;
import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.RechnungDs;
import bai5_hibernate.MPS_AE.hibernate.tables.Rechnung;

@Service
public class RechnungDsImpl extends GenericDsImpl<Rechnung> implements
		RechnungDs<Rechnung> {

	@Override
	protected IGenericDao<Rechnung> getDao() {
		return new RechnungDao();
	}
}
