package bai5_hibernate.MPS_AE;

import org.junit.Before;

import bai5_hibernate.MPS_AE.hibernate.dao.AngebotDao;
import bai5_hibernate.MPS_AE.hibernate.dao.ArbeitsplanDao;
import bai5_hibernate.MPS_AE.hibernate.dao.AuftragDao;
import bai5_hibernate.MPS_AE.hibernate.dao.BauteilDao;
import bai5_hibernate.MPS_AE.hibernate.dao.FertigungsauftragDao;
import bai5_hibernate.MPS_AE.hibernate.dao.KundeDao;
import bai5_hibernate.MPS_AE.hibernate.dao.LieferungDao;
import bai5_hibernate.MPS_AE.hibernate.dao.RechnungDao;
import bai5_hibernate.MPS_AE.hibernate.dao.StuecklisteDao;
import bai5_hibernate.MPS_AE.hibernate.dao.TransportauftragDao;
import bai5_hibernate.MPS_AE.hibernate.dao.VorgangDao;
import bai5_hibernate.MPS_AE.hibernate.dao.ZahlungseingangDao;

public class GeneralTest {

	protected AuftragDao auftragDao;
	protected AngebotDao angebotDao;
	protected ArbeitsplanDao arbeitsplanDao;
	protected BauteilDao bauteilDao;
	protected FertigungsauftragDao fertigungsauftragDao;
	protected KundeDao kundeDao;
	protected LieferungDao lieferungDao;
	protected RechnungDao rechnungDao;
	protected StuecklisteDao stuecklisteDao;
	protected TransportauftragDao transportauftragDao;
	protected VorgangDao vorgangDao;
	protected ZahlungseingangDao zahlungseingangDao;

	@Before
	public void init() {
		this.auftragDao = new AuftragDao();
		this.angebotDao = new AngebotDao();
		this.arbeitsplanDao = new ArbeitsplanDao();
		this.bauteilDao = new BauteilDao();
		this.fertigungsauftragDao = new FertigungsauftragDao();
		this.kundeDao = new KundeDao();
		this.lieferungDao = new LieferungDao();
		this.rechnungDao = new RechnungDao();
		this.stuecklisteDao = new StuecklisteDao();
		this.transportauftragDao = new TransportauftragDao();
		this.vorgangDao = new VorgangDao();
		this.zahlungseingangDao = new ZahlungseingangDao();
	}

}
