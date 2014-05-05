package bai5_hibernate.MPS_AE.hibernate.tables;

import java.io.Serializable;

import javax.persistence.Entity;

import org.hibernate.annotations.Table;

@Entity(name = "Stueckliste")
@Table(appliesTo = "Stueckliste")
public class Stueckliste implements Serializable {

}
