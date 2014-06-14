package bai5_hibernate.MPS_AE.hibernate.ds.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bai5_hibernate.MPS_AE.hibernate.dao.VorgangDao;
import bai5_hibernate.MPS_AE.hibernate.ds.VorgangDs;

@Service
public class VorgangDsImpl implements VorgangDs {
	@Autowired(required = true)
	private VorgangDao vorgangDao;
}
