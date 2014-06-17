package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.LieferungDao;
import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.LieferungDs;
import bai5_hibernate.MPS_AE.hibernate.tables.Lieferung;

@Service
public class LieferungDsImpl extends GenericDsImpl<Lieferung> implements
		LieferungDs<Lieferung> {

	@Override
	protected IGenericDao<Lieferung> getDao() {
		return new LieferungDao();
	}
}
