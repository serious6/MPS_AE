package bai5_hibernate.MPS_AE.hibernate.tables;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

@Entity(name = "Rechnung")
@Table(appliesTo = "Rechnung")
public class Rechnung implements Serializable {
	@Id
	@GeneratedValue
	@GenericGenerator(name = "idGen", strategy = "increment")
	private Long nummer;

	private double paid;

	private double value;

	@OneToOne(fetch = FetchType.EAGER)
	private Auftrag auftrag;

	public double getValue() { return value; }

	public void setValue(double value) { this.value = value; }

	public double getPaid() { return paid; }

	public void setPaid(double paid) { this.paid = paid; }

	public Auftrag getAuftrag() {
		return auftrag;
	}

	public void setAuftrag(Auftrag auftrag) {
		this.auftrag = auftrag;
	}

	public Long getNummer() {
		return nummer;
	}
}
