package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.AngebotDao;
import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.AngebotDs;
import bai5_hibernate.MPS_AE.hibernate.tables.Angebot;

@Service
public class AngebotDsImpl extends GenericDsImpl<Angebot> implements
		AngebotDs<Angebot> {

	@Override
	protected IGenericDao<Angebot> getDao() {
		return new AngebotDao();
	}
}
