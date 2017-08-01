package org.enset.esntities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType=javax.persistence.DiscriminatorType.STRING,length=1)
public abstract class Operation implements Serializable{
	@Id @GeneratedValue
private Long numero;
private Date dateoperation;
private Double montant;
@ManyToOne
@JoinColumn(name="CODE_CPTE")
private Compte compte;
public Operation() {
	super();
	// TODO Auto-generated constructor stub
}
public Operation(Date dateoperation, Double montant, Compte compte) {
	super();
	this.dateoperation = dateoperation;
	this.montant = montant;
	this.compte = compte;
}
public Long getNumero() {
	return numero;
}
public void setNumero(Long numero) {
	this.numero = numero;
}
public Date getDateoperation() {
	return dateoperation;
}
public void setDateoperation(Date dateoperation) {
	this.dateoperation = dateoperation;
}
public Double getMontant() {
	return montant;
}
public void setMontant(Double montant) {
	this.montant = montant;
}
public Compte getCompte() {
	return compte;
}
public void setCompte(Compte compte) {
	this.compte = compte;
}

}
