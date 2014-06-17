package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.TransportauftragDao;
import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.TransportauftragDs;
import bai5_hibernate.MPS_AE.hibernate.tables.Transportauftrag;

@Service
public class TransportauftragDsImpl extends GenericDsImpl<Transportauftrag>
		implements TransportauftragDs<Transportauftrag> {

	@Override
	protected IGenericDao<Transportauftrag> getDao() {
		return new TransportauftragDao();
	}
}
