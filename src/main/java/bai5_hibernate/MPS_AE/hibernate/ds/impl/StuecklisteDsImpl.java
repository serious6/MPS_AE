package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.StuecklisteDao;
import bai5_hibernate.MPS_AE.hibernate.ds.StuecklisteDs;

@Service
public class StuecklisteDsImpl implements StuecklisteDs {
	@Autowired(required = true)
	private StuecklisteDao stuecklisteDao;
}
