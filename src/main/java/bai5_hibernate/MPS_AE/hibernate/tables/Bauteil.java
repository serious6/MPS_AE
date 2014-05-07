package bai5_hibernate.MPS_AE.hibernate.tables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

@Entity(name = "Bauteil")
@Table(appliesTo = "Bauteil")
public class Bauteil implements Serializable {
	@Id
	@GeneratedValue
	@GenericGenerator(name = "idGen", strategy = "increment")
	private Long nummer;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Fertigungsauftrag> fertigungsauftragListe = new HashSet<Fertigungsauftrag>();
	
	@OneToOne
	private Arbeitsplan arbeitsplan;
	
	@OneToOne
	private Stueckliste stueckliste;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<StuecklistenPosition> stuecklistenPositions = new HashSet<StuecklistenPosition>();

	public Set<Fertigungsauftrag> getFertigungsauftragListe() {
		return fertigungsauftragListe;
	}

	public void setFertigungsauftragListe(
			Set<Fertigungsauftrag> fertigungsauftragListe) {
		this.fertigungsauftragListe = fertigungsauftragListe;
	}
	
	public void addFertigungsauftrag(Fertigungsauftrag fertigungsauftrag){
		this.fertigungsauftragListe.add(fertigungsauftrag);
	}

	public Arbeitsplan getArbeitsplan() {
		return arbeitsplan;
	}

	public void setArbeitsplan(Arbeitsplan arbeitsplan) {
		this.arbeitsplan = arbeitsplan;
	}

	public Stueckliste getStueckliste() {
		return stueckliste;
	}

	public void setStueckliste(Stueckliste stueckliste) {
		this.stueckliste = stueckliste;
	}

	public Set<StuecklistenPosition> getStuecklistenPositions() {
		return stuecklistenPositions;
	}

	public void setStuecklistenPositions(
			Set<StuecklistenPosition> stuecklistenPositions) {
		this.stuecklistenPositions = stuecklistenPositions;
	}
	
	public void addStuecklistenPosition(StuecklistenPosition stuecklistenPosition){
		this.stuecklistenPositions.add(stuecklistenPosition);
	}

	public Long getNummer() {
		return nummer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
