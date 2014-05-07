package bai5_hibernate.MPS_AE.hibernate.tables;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

@Entity(name = "Auftrag")
@Table(appliesTo = "Auftrag")
public class Auftrag implements Serializable {

	@Id
	@GeneratedValue
	@GenericGenerator(name = "idGen", strategy = "increment")
	private Long nummer;

	private boolean istAbgeschlossen;

	private Date beauftragtAm;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Fertigungsauftrag fertigungsauftrag;

	public boolean isIstAbgeschlossen() {
		return istAbgeschlossen;
	}

	public void setIstAbgeschlossen(boolean istAbgeschlossen) {
		this.istAbgeschlossen = istAbgeschlossen;
	}

	public Date getBeauftragtAm() {
		return beauftragtAm;
	}

	public void setBeauftragtAm(Date beauftragtAm) {
		this.beauftragtAm = beauftragtAm;
	}

	public Fertigungsauftrag getFertigungsauftrag() {
		return fertigungsauftrag;
	}

	public void setFertigungsauftrag(Fertigungsauftrag fertigungsauftrag) {
		this.fertigungsauftrag = fertigungsauftrag;
	}

	public Long getNummer() {
		return nummer;
	}
}
