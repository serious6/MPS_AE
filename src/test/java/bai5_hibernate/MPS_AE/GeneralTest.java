package bai5_hibernate.MPS_AE;

import org.junit.Before;

import bai5_hibernate.MPS_AE.hibernate.dao.AuftragDao;

public class GeneralTest {

	protected AuftragDao auftragDao;

	@Before
	public void init() {
		this.auftragDao = new AuftragDao();
	}

}
