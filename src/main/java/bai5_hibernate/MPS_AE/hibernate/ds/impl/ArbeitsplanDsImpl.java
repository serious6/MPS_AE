package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.ArbeitsplanDao;
import bai5_hibernate.MPS_AE.hibernate.ds.ArbeitsplanDs;

@Service
public class ArbeitsplanDsImpl implements ArbeitsplanDs {
	@Autowired(required = true)
	private ArbeitsplanDao arbeitsplanDao;
}
