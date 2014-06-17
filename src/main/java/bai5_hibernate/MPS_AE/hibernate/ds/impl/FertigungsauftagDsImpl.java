package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.FertigungsauftragDao;
import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.FertigungsauftragDs;
import bai5_hibernate.MPS_AE.hibernate.tables.Fertigungsauftrag;

@Service
public class FertigungsauftagDsImpl extends GenericDsImpl<Fertigungsauftrag>
		implements FertigungsauftragDs<Fertigungsauftrag> {

	@Override
	protected IGenericDao<Fertigungsauftrag> getDao() {
		return new FertigungsauftragDao();
	}

}