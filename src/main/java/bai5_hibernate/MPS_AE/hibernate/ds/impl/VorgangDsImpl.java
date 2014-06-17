package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.VorgangDao;
import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.VorgangDs;
import bai5_hibernate.MPS_AE.hibernate.tables.Vorgang;

@Service
public class VorgangDsImpl extends GenericDsImpl<Vorgang> implements
		VorgangDs<Vorgang> {

	@Override
	protected IGenericDao<Vorgang> getDao() {
		return new VorgangDao();
	}
}
