package bai5_hibernate.MPS_AE.hibernate.tables;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

@Entity(name = "Arbeitsplan")
@Table(appliesTo = "Arbeitsplan")
public class Arbeitsplan implements Serializable {
	@Id
	@GeneratedValue
	@GenericGenerator(name = "idGen", strategy = "increment")
	private Long nummer;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Bauteil bauteil;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Vorgang> vorgangsListe = new HashSet<Vorgang>();

	public Bauteil getBauteil() {
		return bauteil;
	}

	public void setBauteil(Bauteil bauteil) {
		this.bauteil = bauteil;
	}

	public Set<Vorgang> getVorgangsListe() {
		return vorgangsListe;
	}

	public void setVorgangsListe(Set<Vorgang> vorgangsListe) {
		this.vorgangsListe = vorgangsListe;
	}

	public Long getNummer() {
		return nummer;
	}
}
