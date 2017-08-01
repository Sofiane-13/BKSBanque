package org.enset.metier;

import org.enset.esntities.Compte;
import org.enset.esntities.Operation;
import org.springframework.data.domain.Page;

public interface IBanqueMetier {
public Compte consulterCompte(String CodeCpte);
public void verser(String CodeCpte,double montant);
public void retirer(String CodeCpte,double montant);
public void virement(String CodeCpte1, String CodeCpte2, double montant);
public Page<Operation> listeoperation(String CodeCpte, int page,int size);
}
