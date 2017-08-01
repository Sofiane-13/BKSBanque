package org.enset.esntities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{
private Double taux;

public CompteEpargne() {
	super();
	// TODO Auto-generated constructor stub
}

public CompteEpargne(String codeCompe, Date dateCreation, Double solde, Client client, Double taux) {
	super(codeCompe, dateCreation, solde, client);
	this.taux = taux;
}

public Double getTaux() {
	return taux;
}

public void setTaux(Double taux) {
	this.taux = taux;
}

}
