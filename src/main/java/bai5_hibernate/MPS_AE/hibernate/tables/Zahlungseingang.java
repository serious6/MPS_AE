package bai5_hibernate.MPS_AE.hibernate.tables;

import java.io.Serializable;

import javax.persistence.Entity;

import org.hibernate.annotations.Table;

@Entity(name = "Zahlungseingang")
@Table(appliesTo = "Zahlungseingang")
public class Zahlungseingang implements Serializable {

}
