package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.KundeDao;
import bai5_hibernate.MPS_AE.hibernate.ds.KundeDs;

@Service
public class KundeDsImpl implements KundeDs {
	@Autowired(required = true)
	private KundeDao kundeDao;
}
