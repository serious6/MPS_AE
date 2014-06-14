package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.TransportauftragDao;
import bai5_hibernate.MPS_AE.hibernate.ds.TransportauftragDs;

@Service
public class TransportauftragDsImpl implements TransportauftragDs {
	@Autowired(required = true)
	private TransportauftragDao transportauftragDao;
}
