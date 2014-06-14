package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.BauteilDao;
import bai5_hibernate.MPS_AE.hibernate.ds.BauteilDs;

@Service
public class BauteilDsImpl implements BauteilDs {
	@Autowired(required = true)
	private BauteilDao bauteilDao;
}
