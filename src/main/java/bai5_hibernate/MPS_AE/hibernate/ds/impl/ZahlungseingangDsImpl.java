package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.ZahlungseingangDao;
import bai5_hibernate.MPS_AE.hibernate.ds.ZahlungseingangDs;

@Service
public class ZahlungseingangDsImpl implements ZahlungseingangDs {

	@Autowired(required = true)
	private ZahlungseingangDao zahlungseingangDao;
}
