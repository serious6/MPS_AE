package bai5_hibernate.MPS_AE;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import bai5_hibernate.MPS_AE.hibernate.tables.Arbeitsplan;
import bai5_hibernate.MPS_AE.hibernate.tables.Auftrag;
import bai5_hibernate.MPS_AE.hibernate.tables.Bauteil;
import bai5_hibernate.MPS_AE.hibernate.tables.Fertigungsauftrag;
import bai5_hibernate.MPS_AE.hibernate.tables.Vorgang;
import bai5_hibernate.MPS_AE.hibernate.tables.VorgangArtTyp;

public class AuftragTest extends GeneralTest {

	private Fertigungsauftrag fertigungsauftrag;
	private Bauteil bauteil;
	private Arbeitsplan arbeitsplan;
	private Vorgang vorgang;
	private Auftrag auftrag;

	@Test
	public void test1() throws Exception {
		auftrag = new Auftrag();
		auftrag.setBeauftragtAm(new Date());
		auftrag.setIstAbgeschlossen(false);
		auftrag.setFertigungsauftrag(getFertigungsauftrag(auftrag));

		auftragDs.add(auftrag);

		fertigungsauftrag.setAuftrag(auftrag);
		fertigungsauftragDs.update(fertigungsauftrag);

		Assert.assertNotNull(auftrag.getNummer());
	}

	private Fertigungsauftrag getFertigungsauftrag(Auftrag auftrag)
			throws Exception {
		fertigungsauftrag = new Fertigungsauftrag();
		fertigungsauftrag.setBauteil(getBauteil(fertigungsauftrag));

		fertigungsauftragDs.add(fertigungsauftrag);
		return fertigungsauftrag;
	}

	private Bauteil getBauteil(Fertigungsauftrag fertigungsauftrag)
			throws Exception {
		bauteil = new Bauteil();
		bauteil.setArbeitsplan(getArbeitsplan(bauteil));
		bauteil.setName("Erstes Bauteil");

		bauteilDs.add(bauteil);
		bauteil.addFertigungsauftrag(fertigungsauftrag);
		bauteilDs.update(bauteil);

		arbeitsplan.setBauteil(bauteil);
		arbeitsplanDs.update(arbeitsplan);

		return bauteil;
	}

	private Arbeitsplan getArbeitsplan(Bauteil bauteil) throws Exception {
		arbeitsplan = new Arbeitsplan();
		arbeitsplan.setVorgangsListe(getVorgaenge(arbeitsplan));

		arbeitsplanDs.add(arbeitsplan);

		vorgang.setArbeitsplan(arbeitsplan);
		vorgangDs.update(vorgang);

		return arbeitsplan;
	}

	private Set<Vorgang> getVorgaenge(Arbeitsplan arbeitsplan) throws Exception {
		HashSet<Vorgang> vorgangsliste = new HashSet<Vorgang>();
		vorgang = new Vorgang();
		vorgang.setArt(VorgangArtTyp.BEREITSTELLUNG);

		vorgangDs.add(vorgang);
		vorgangsliste.add(vorgang);
		return vorgangsliste;
	}

	@Test
	public void testFertigungArtikel() throws Exception {
		auftragErstellen();

		auftrag = auftragDs.findById(auftrag.getNummer());
		arbeitsplan = auftrag.getFertigungsauftrag().getBauteil()
				.getArbeitsplan();

		Vorgang vorgang2 = null;
		for (Vorgang vorgang : arbeitsplan.getVorgangsListe()) {
			vorgang.setArt(VorgangArtTyp.MONTAGE);
			vorgangDs.update(vorgang);

			vorgang2 = vorgang;
		}

		Assert.assertSame(VorgangArtTyp.MONTAGE,
				vorgangDs.findById(vorgang2.getNummer()).getArt());
	}

	// @Test
	// public void testComplex() throws Exception{
	// Bauteil bauteil = bauteilDs.findById(1l);
	//
	// Assert.assertFalse(bauteilDs.isComplex(bauteil));
	// }

	private void auftragErstellen() throws Exception {
		auftrag = new Auftrag();
		auftrag.setBeauftragtAm(new Date());
		auftrag.setIstAbgeschlossen(false);
		auftrag.setFertigungsauftrag(getFertigungsauftrag(auftrag));

		auftragDs.add(auftrag);

		fertigungsauftrag.setAuftrag(auftrag);
		fertigungsauftragDs.update(fertigungsauftrag);
	}

}
