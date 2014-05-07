package bai5_hibernate.MPS_AE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	@Test
	public void test1() throws Exception {
		Auftrag auftrag = new Auftrag();
		auftrag.setBeauftragtAm(new Date());
		auftrag.setIstAbgeschlossen(false);
		auftrag.setFertigungsauftrag(getFertigungsauftrag(auftrag));
		
		auftragDao.add(auftrag);
		
		fertigungsauftrag.setAuftrag(auftrag);
		fertigungsauftragDao.update(fertigungsauftrag);
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

	private List<Vorgang> getVorgaenge(Arbeitsplan arbeitsplan) throws Exception {
		ArrayList<Vorgang> vorgangsliste = new ArrayList<Vorgang>();
		vorgang = new Vorgang();
		vorgang.setArt(VorgangArtTyp.BEREITSTELLUNG);
		
		vorgangDao.add(vorgang);
		vorgangsliste.add(vorgang);
		return vorgangsliste;
	}
	
	public void testFertigungArtikel(){
		
	}

}
