package bai5_hibernate.MPS_AE.hibernate.tables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

@Entity(name = "Arbeitsplan")
@Table(appliesTo = "Arbeitsplan")
public class Arbeitsplan implements Serializable {
	@Id
	@GeneratedValue
	@GenericGenerator(name = "idGen", strategy = "increment")
	private Long nummer;
}
