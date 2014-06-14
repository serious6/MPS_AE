package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.LieferungDao;
import bai5_hibernate.MPS_AE.hibernate.ds.LieferungDs;

@Service
public class LieferungDsImpl implements LieferungDs {
	@Autowired(required = true)
	private LieferungDao lieferungDao;
}
