package bai5_hibernate.MPS_AE;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bai5_hibernate.MPS_AE.hibernate.ds.FertigungsauftragDs;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.FertigungsauftagDsImpl;
import bai5_hibernate.MPS_AE.hibernate.tables.Fertigungsauftrag;

public class FertigungsauftragTest {

	FertigungsauftragDs<Fertigungsauftrag> fertigungsauftragDs = new FertigungsauftagDsImpl();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		Fertigungsauftrag fertigungsauftrag = new Fertigungsauftrag();
		fertigungsauftragDs.add(fertigungsauftrag);
	}
}
