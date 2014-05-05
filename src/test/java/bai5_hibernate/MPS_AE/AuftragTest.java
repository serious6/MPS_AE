package bai5_hibernate.MPS_AE;

import org.junit.Test;

import bai5_hibernate.MPS_AE.hibernate.tables.Auftrag;

public class AuftragTest extends GeneralTest {

	@Test
	public void test1() throws Exception {
		Auftrag auftrag = new Auftrag();
		auftragDao.add(auftrag);
	}

}
