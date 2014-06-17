package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.KundeDao;
import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.KundeDs;
import bai5_hibernate.MPS_AE.hibernate.tables.Kunde;

@Service
public class KundeDsImpl extends GenericDsImpl<Kunde> implements KundeDs<Kunde> {

	@Override
	protected IGenericDao<Kunde> getDao() {
		return new KundeDao();
	}
}
