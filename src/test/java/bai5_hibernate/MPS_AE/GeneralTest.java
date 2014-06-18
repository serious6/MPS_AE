package bai5_hibernate.MPS_AE;

import org.junit.Before;

import bai5_hibernate.MPS_AE.hibernate.ds.AngebotDs;
import bai5_hibernate.MPS_AE.hibernate.ds.ArbeitsplanDs;
import bai5_hibernate.MPS_AE.hibernate.ds.AuftragDs;
import bai5_hibernate.MPS_AE.hibernate.ds.BauteilDs;
import bai5_hibernate.MPS_AE.hibernate.ds.FertigungsauftragDs;
import bai5_hibernate.MPS_AE.hibernate.ds.KundeDs;
import bai5_hibernate.MPS_AE.hibernate.ds.LieferungDs;
import bai5_hibernate.MPS_AE.hibernate.ds.RechnungDs;
import bai5_hibernate.MPS_AE.hibernate.ds.StuecklisteDs;
import bai5_hibernate.MPS_AE.hibernate.ds.TransportauftragDs;
import bai5_hibernate.MPS_AE.hibernate.ds.VorgangDs;
import bai5_hibernate.MPS_AE.hibernate.ds.ZahlungseingangDs;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.AngebotDsImpl;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.ArbeitsplanDsImpl;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.AuftragDsImpl;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.BauteilDsImpl;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.FertigungsauftagDsImpl;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.KundeDsImpl;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.LieferungDsImpl;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.RechnungDsImpl;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.StuecklisteDsImpl;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.TransportauftragDsImpl;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.VorgangDsImpl;
import bai5_hibernate.MPS_AE.hibernate.ds.impl.ZahlungseingangDsImpl;
import bai5_hibernate.MPS_AE.hibernate.tables.Angebot;
import bai5_hibernate.MPS_AE.hibernate.tables.Arbeitsplan;
import bai5_hibernate.MPS_AE.hibernate.tables.Auftrag;
import bai5_hibernate.MPS_AE.hibernate.tables.Bauteil;
import bai5_hibernate.MPS_AE.hibernate.tables.Fertigungsauftrag;
import bai5_hibernate.MPS_AE.hibernate.tables.Kunde;
import bai5_hibernate.MPS_AE.hibernate.tables.Lieferung;
import bai5_hibernate.MPS_AE.hibernate.tables.Rechnung;
import bai5_hibernate.MPS_AE.hibernate.tables.Stueckliste;
import bai5_hibernate.MPS_AE.hibernate.tables.Transportauftrag;
import bai5_hibernate.MPS_AE.hibernate.tables.Vorgang;
import bai5_hibernate.MPS_AE.hibernate.tables.Zahlungseingang;

public class GeneralTest {

	protected AuftragDs<Auftrag> auftragDs;
	protected AngebotDs<Angebot> angebotDs;
	protected ArbeitsplanDs<Arbeitsplan> arbeitsplanDs;
	protected BauteilDs<Bauteil> bauteilDs;
	protected FertigungsauftragDs<Fertigungsauftrag> fertigungsauftragDs;
	protected KundeDs<Kunde> kundeDs;
	protected LieferungDs<Lieferung> lieferungDs;
	protected RechnungDs<Rechnung> rechnungDs;
	protected StuecklisteDs<Stueckliste> stuecklisteDs;
	protected TransportauftragDs<Transportauftrag> transportauftragDs;
	protected VorgangDs<Vorgang> vorgangDs;
	protected ZahlungseingangDs<Zahlungseingang> zahlungseingangDs;

	@Before
	public void init() {
		this.auftragDs = new AuftragDsImpl();
		this.angebotDs = new AngebotDsImpl();
		this.arbeitsplanDs = new ArbeitsplanDsImpl();
		this.bauteilDs = new BauteilDsImpl();
		this.fertigungsauftragDs = new FertigungsauftagDsImpl();
		this.kundeDs = new KundeDsImpl();
		this.lieferungDs = new LieferungDsImpl();
		this.rechnungDs = new RechnungDsImpl();
		this.stuecklisteDs = new StuecklisteDsImpl();
		this.transportauftragDs = new TransportauftragDsImpl();
		this.vorgangDs = new VorgangDsImpl();
		this.zahlungseingangDs = new ZahlungseingangDsImpl();
	}

}
