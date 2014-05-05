package bai5_hibernate.MPS_AE.hibernate.tables;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

@Entity(name = "Kunde")
@Table(appliesTo = "Kunde")
public class Kunde implements Serializable {
	@Id
	@GeneratedValue
	@GenericGenerator(name = "idGen", strategy = "increment")
	private Long nummer;

	@Column(nullable = false)
	private String vorname;

	@Column(nullable = false)
	private String nachname;

	@Column(nullable = true)
	private String adresse;
}
