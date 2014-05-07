package bai5_hibernate.MPS_AE.hibernate.tables;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

@Entity(name = "Vorgang")
@Table(appliesTo = "Vorgang")
public class Vorgang implements Serializable {
	@Id
	@GeneratedValue
	@GenericGenerator(name = "idGen", strategy = "increment")
	private Long nummer;

	@Column(nullable = false)
	private VorgangArtTyp art;
	
	private long ruestzeit;
	private long maschinenzeit;
	private long personenzeit;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Arbeitsplan arbeitsplan;

	public VorgangArtTyp getArt() {
		return art;
	}

	public void setArt(VorgangArtTyp art) {
		this.art = art;
	}

	public Arbeitsplan getArbeitsplan() {
		return arbeitsplan;
	}

	public void setArbeitsplan(Arbeitsplan arbeitsplan) {
		this.arbeitsplan = arbeitsplan;
	}

	public Long getNummer() {
		return nummer;
	}

	public long getRuestzeit() {
		return ruestzeit;
	}

	public void setRuestzeit(long ruestzeit) {
		this.ruestzeit = ruestzeit;
	}

	public long getMaschinenzeit() {
		return maschinenzeit;
	}

	public void setMaschinenzeit(long maschinenzeit) {
		this.maschinenzeit = maschinenzeit;
	}

	public long getPersonenzeit() {
		return personenzeit;
	}

	public void setPersonenzeit(long personenzeit) {
		this.personenzeit = personenzeit;
	}
}
