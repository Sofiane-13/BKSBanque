package org.enset.esntities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation{

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date dateoperation, Double montant, Compte compte) {
		super(dateoperation, montant, compte);
		// TODO Auto-generated constructor stub
	}

}
