package bai5_hibernate.MPS_AE.hibernate.tables;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
