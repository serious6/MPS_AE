package bai5_hibernate.MPS_AE.hibernate.tables;

import java.io.Serializable;

import javax.persistence.Entity;

import org.hibernate.annotations.Table;

@Entity(name = "StuecklistenPosition")
@Table(appliesTo = "StuecklistenPosition")
public class StuecklistenPosition implements Serializable {

}
