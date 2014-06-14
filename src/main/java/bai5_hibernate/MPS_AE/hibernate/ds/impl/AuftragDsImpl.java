package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.AuftragDao;
import bai5_hibernate.MPS_AE.hibernate.ds.AuftragDs;

@Service
public class AuftragDsImpl implements AuftragDs {
	@Autowired(required = true)
	private AuftragDao auftragDao;
}
