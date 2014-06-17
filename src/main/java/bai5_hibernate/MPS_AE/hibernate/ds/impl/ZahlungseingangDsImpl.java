package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.ZahlungseingangDao;
import bai5_hibernate.MPS_AE.hibernate.dao.generic.IGenericDao;
import bai5_hibernate.MPS_AE.hibernate.ds.ZahlungseingangDs;
import bai5_hibernate.MPS_AE.hibernate.tables.Zahlungseingang;

@Service
public class ZahlungseingangDsImpl extends GenericDsImpl<Zahlungseingang>
		implements ZahlungseingangDs<Zahlungseingang> {

	@Override
	protected IGenericDao<Zahlungseingang> getDao() {
		return new ZahlungseingangDao();
	}

}
