package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.AuftragDao;
import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.AuftragDs;
import bai5_hibernate.MPS_AE.hibernate.tables.Auftrag;

@Service
public class AuftragDsImpl extends GenericDsImpl<Auftrag> implements
		AuftragDs<Auftrag> {

	@Override
	protected IGenericDao<Auftrag> getDao() {
		return new AuftragDao();
	}
}
