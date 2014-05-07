package bai5_hibernate.MPS_AE.hibernate.tables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
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
	private List<Fertigungsauftrag> fertigungsauftragListe = new ArrayList<Fertigungsauftrag>();
	
	@OneToOne
	private Arbeitsplan arbeitsplan;
	
	@OneToOne
	private Stueckliste stueckliste;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<StuecklistenPosition> stuecklistenPositions = new ArrayList<StuecklistenPosition>();

	public List<Fertigungsauftrag> getFertigungsauftragListe() {
		return fertigungsauftragListe;
	}

	public void setFertigungsauftragListe(
			List<Fertigungsauftrag> fertigungsauftragListe) {
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

	public List<StuecklistenPosition> getStuecklistenPositions() {
		return stuecklistenPositions;
	}

	public void setStuecklistenPositions(
			List<StuecklistenPosition> stuecklistenPositions) {
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
