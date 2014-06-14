package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.AngebotDao;
import bai5_hibernate.MPS_AE.hibernate.ds.AngebotDs;

@Service
public class AngebotDsImpl implements AngebotDs {
	@Autowired(required = true)
	private AngebotDao angebotDao;
}
