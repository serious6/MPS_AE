package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.FertigungsauftragDao;
import bai5_hibernate.MPS_AE.hibernate.ds.FertigungsauftragDs;

@Service
public class FertigungsauftagDsImpl implements FertigungsauftragDs {
	@Autowired(required = true)
	private FertigungsauftragDao fertigungsauftragDao;
}
