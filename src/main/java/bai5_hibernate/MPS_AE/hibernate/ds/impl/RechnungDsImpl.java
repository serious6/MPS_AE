package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.RechnungDao;
import bai5_hibernate.MPS_AE.hibernate.ds.RechnungDs;

@Service
public class RechnungDsImpl implements RechnungDs {
	@Autowired(required = true)
	private RechnungDao rechnungDao;
}
