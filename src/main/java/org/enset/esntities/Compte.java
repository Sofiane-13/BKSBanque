package org.enset.esntities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=javax.persistence.DiscriminatorType.STRING,length=2)
public abstract class Compte implements Serializable{
	@Id
private String codeCompte;
private Date dateCreation;
private Double solde;
@ManyToOne
@JoinColumn(name="CODE_CLI")
private Client client;
@OneToMany(mappedBy="compte")
private Collection<Operation> operations;
public Compte() {
	super();
	// TODO Auto-generated constructor stub
}
public Compte(String codeCompte, Date dateCreation, Double solde, Client client) {
	super();
	this.codeCompte = codeCompte;
	this.dateCreation = dateCreation;
	this.solde = solde;
	this.client = client;
}
public String getCodeCompe() {
	return codeCompte;
}
public void setCodeCompe(String codeCompe) {
	this.codeCompte = codeCompe;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
public Double getSolde() {
	return solde;
}
public void setSolde(Double solde) {
	this.solde = solde;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Collection<Operation> getOperations() {
	return operations;
}
public void setOperations(Collection<Operation> operations) {
	this.operations = operations;
}

}
