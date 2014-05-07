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
		
		auftragDao.add(auftrag);
		
		fertigungsauftrag.setAuftrag(auftrag);
		fertigungsauftragDao.update(fertigungsauftrag);
		
		Assert.assertNotNull(auftrag.getNummer());
	}

	private Fertigungsauftrag getFertigungsauftrag(Auftrag auftrag) throws Exception {
		fertigungsauftrag = new Fertigungsauftrag();
		fertigungsauftrag.setBauteil(getBauteil(fertigungsauftrag));
		
		fertigungsauftragDao.add(fertigungsauftrag);
		return fertigungsauftrag;
	}

	private Bauteil getBauteil(Fertigungsauftrag fertigungsauftrag) throws Exception {
		bauteil = new Bauteil();
		bauteil.setArbeitsplan(getArbeitsplan(bauteil));
		bauteil.setName("Erstes Bauteil");
		
		bauteilDao.add(bauteil);
		bauteil.addFertigungsauftrag(fertigungsauftrag);
		bauteilDao.update(bauteil);
		
		arbeitsplan.setBauteil(bauteil);
		arbeitsplanDao.update(arbeitsplan);
		
		return bauteil;
	}

	private Arbeitsplan getArbeitsplan(Bauteil bauteil) throws Exception {
		arbeitsplan = new Arbeitsplan();
		arbeitsplan.setVorgangsListe(getVorgaenge(arbeitsplan));
		
		arbeitsplanDao.add(arbeitsplan);
		
		vorgang.setArbeitsplan(arbeitsplan);
		vorgangDao.update(vorgang);
		
		return arbeitsplan;
	}

	private Set<Vorgang> getVorgaenge(Arbeitsplan arbeitsplan) throws Exception {
		HashSet<Vorgang> vorgangsliste = new HashSet<Vorgang>();
		vorgang = new Vorgang();
		vorgang.setArt(VorgangArtTyp.BEREITSTELLUNG);
		
		vorgangDao.add(vorgang);
		vorgangsliste.add(vorgang);
		return vorgangsliste;
	}
	
	@Test
	public void testFertigungArtikel() throws Exception{
		auftragErstellen();
		
		auftrag = auftragDao.findById(auftrag.getNummer());
		arbeitsplan = auftrag.getFertigungsauftrag().getBauteil().getArbeitsplan();
		
		Vorgang vorgang2 = null;
		for (Vorgang vorgang : arbeitsplan.getVorgangsListe()) {
			vorgang.setArt(VorgangArtTyp.MONTAGE);
			vorgangDao.update(vorgang);
			
			vorgang2 = vorgang;
		}
		
		Assert.assertSame(VorgangArtTyp.MONTAGE, vorgangDao.findById(vorgang2.getNummer()).getArt());
	}
	
	@Test
	public void testComplex() throws Exception{
		Bauteil bauteil = bauteilDao.findById(1l);
		
		Assert.assertFalse(bauteilDao.isComplex(bauteil));
	}

	private void auftragErstellen() throws Exception {
		auftrag = new Auftrag();
		auftrag.setBeauftragtAm(new Date());
		auftrag.setIstAbgeschlossen(false);
		auftrag.setFertigungsauftrag(getFertigungsauftrag(auftrag));
		
		auftragDao.add(auftrag);
		
		fertigungsauftrag.setAuftrag(auftrag);
		fertigungsauftragDao.update(fertigungsauftrag);		
	}

}
