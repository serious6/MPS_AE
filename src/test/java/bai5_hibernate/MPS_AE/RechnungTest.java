package bai5_hibernate.MPS_AE;

import org.junit.Test;

import bai5_hibernate.MPS_AE.hibernate.tables.Auftrag;
import bai5_hibernate.MPS_AE.hibernate.tables.Rechnung;

public class RechnungTest extends GeneralTest {

	@Test
	public void createRechnung() throws Exception {
		Auftrag auftrag = auftragDs.findById(1);
		Rechnung rechnung = new Rechnung();
		rechnung.setAuftrag(auftrag);
		rechnung.setPaid(0);
		rechnung.setValue(1000);

		rechnungDs.add(rechnung);
	}

}
